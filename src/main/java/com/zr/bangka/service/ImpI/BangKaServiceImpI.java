package com.zr.bangka.service.ImpI;


import com.zr.bangka.mapper.BangKaMapper;
import com.zr.bangka.pojo.*;
import com.zr.bangka.service.BangKaService;
import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.meiju.BankCardEnum;
import com.zr.meiju.CardEnum;
import com.zr.meiju.OrderNumEnum;
import com.zr.meiju.YanZhengEnum;
import com.zr.util.*;
import com.zr.xinshenstatistics.util.ResultVo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class BangKaServiceImpI implements BangKaService {
    @Autowired
    private BangKaMapper bangKaMapper;

    @Override
    public ResultVO bangka(List<BangKaShowVo> bangKaShowVoList) {
        List<String> orderNumberList = new ArrayList<>();
        //先验证数据是否存在，把存在了的数据删除掉
        for (BangKaShowVo bangKaShowVo:bangKaShowVoList){
            orderNumberList.add(bangKaShowVo.getBankCard());
        }
        List<BangKaShowVo>  bangKaShowVos = bangKaMapper.queryBankCardByCodes(orderNumberList);
        if(!CollectionUtils.isEmpty(bangKaShowVos)){
            bangKaMapper.updateStatus(bangKaShowVos);
            bangKaMapper.insertBangKa(bangKaShowVoList);

        }else{
            bangKaMapper.insertBangKa(bangKaShowVoList);
        }
        return ResultVOBuilder.success(bangKaShowVoList);
    }

    @Override
    public ResultVO<AllRecords> queryPage(BangKaSelectVo bangKaSelectVo) {
        //查询数据
        List<BangKaVo> bangKaVoList = bangKaMapper.queryPage(bangKaSelectVo);

        for (BangKaVo bangKaVo:bangKaVoList){
            //给卡状态赋值中文
            Integer cardStatus = bangKaVo.getCardStatus()==true?0:1;
            bangKaVo.setCardStatusName(CardEnum.getName(cardStatus));
            //给验证状态赋值中文
            bangKaVo.setYanZhengStatusName(YanZhengEnum.getName(bangKaVo.getYanZhengStatus()));
            //给银行开户行赋值中文
            bangKaVo.setBankTypeName(BankCardEnum.getName(bangKaVo.getBankCardType()));
        }
        //查询数量
        int count = bangKaMapper.queryCount(bangKaSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(bangKaSelectVo.getPageIndex());
        allRecords.setPageSize(bangKaSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(bangKaVoList);
        return ResultVOBuilder.success(allRecords);

    }
    @Override
    @Transactional
    public ResultVO bangKaAdd(BangKaAddVo bangKaAddVo) {
        BangKaVo bangKaVo = bangKaMapper.queryAll(bangKaAddVo);

        if(bangKaVo==null){
            bangKaMapper.bangKaAdd(bangKaAddVo);
        }else {
           return ResultVOBuilder.error("存入对象已存在","");
        }
        return ResultVOBuilder.success(bangKaAddVo);
    }

    @Override
    @Transactional
    public ResultVO send(BangKaShowVo bangKaShowVo) {
        //验证数据是否存在
        List<String> loanContractNumList = bangKaMapper.queryByNum(bangKaShowVo.getBankCard());
        if (CollectionUtils.isEmpty(loanContractNumList)){
            return ResultVOBuilder.error("修改数据不存在！","");
        }
        bangKaMapper.update(bangKaShowVo);
        bangKaMapper.insert(bangKaShowVo);
        return ResultVOBuilder.success(bangKaShowVo);
    }

    @Override
    public ResultVO yinhang(YinHangVo yinHangVo) {

        //先查询这条数据存不存在
        YinHangVo yinHangVo1 = bangKaMapper.queryByCode(yinHangVo.getIdCode());
        if (yinHangVo1 == null) {
            return ResultVOBuilder.error("您查询身份证号码不存在","");
        }
        yinHangVo = bangKaMapper.yinhangFindAll(yinHangVo);
        Integer row = 0;
        if (yinHangVo != null) {
            //修改数据
            row = bangKaMapper.deleteYinHang(yinHangVo);
            row = bangKaMapper.addYinHang(yinHangVo);
        }
        //新增数据
        row = bangKaMapper.addYinHang(yinHangVo);

        yinHangVo.setReceiveStatus("接收成功");
        return ResultVOBuilder.success(yinHangVo);
    }

    @Override
    public ResultVO exportExcel(HttpServletResponse response, BangKaSelectVo bangKaSelectVo) throws Exception {
        //从数据库中查询出将要导出的数据
        List<BangKaVo> bangKaVoList = bangKaMapper.queryBySelectVo(bangKaSelectVo);
        for (BangKaVo bangKaVo:bangKaVoList){
            //给卡状态赋值中文
            Integer cardStatus = bangKaVo.getCardStatus()==true?0:1;
            bangKaVo.setCardStatusName(CardEnum.getName(cardStatus));
            //给验证状态赋值中文
            bangKaVo.setYanZhengStatusName(YanZhengEnum.getName(bangKaVo.getYanZhengStatus()));
            //给银行开户行赋值中文
            bangKaVo.setBankTypeName(BankCardEnum.getName(bangKaVo.getBankCardType()));
        }
        //限制，默认只允许导出10000条数据
        int count = bangKaMapper.queryCount(bangKaSelectVo);
        if (count>10000){
            return ResultVOBuilder.error("默认只允许导出10000条数据！请增加条件导出","500");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "客户绑卡模板");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/客户绑卡.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", bangKaVoList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }

    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<BangKaVo> resultList, ServletOutputStream out) throws Exception {
        //POi读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfo( sheet, resultList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭poi方法
        wb.close();
    }

    /**
     * 插入excel表中项目信息
     *
     * @param sheet
     */
    private void toResultListValueInfo(Sheet sheet, List<BangKaVo> bangKaVoList) {
        //从第五行开始赋值
        int row_column = 4;
        //遍历数据集合
        for (BangKaVo obj : bangKaVoList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, obj.getId() + "");
            // 给第二列编码赋值
            POIClass.toCellValue(row, 1, obj.getCustomerName() + "");
            // 给第3列名称赋值
            POIClass.toCellValue(row, 2, obj.getPhone() + "");
            // 给状态赋值
            POIClass.toCellValue(row, 3, obj.getBankCard() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getPhone() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getBankCardType() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getCardStatus() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getYanZhengStatus() + "");
            row_column++;
        }
    }

}

