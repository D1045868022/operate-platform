package com.zr.earliersettlement.service.impl;


import com.zr.earliersettlement.mapper.EarliersettlementMapper;
import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.pojo.EarliersettlementShowVo;
import com.zr.earliersettlement.pojo.Riskreserve_Capitalside;
import com.zr.earliersettlement.service.EarliersettlementService;
import com.zr.meiju.OrderNumEnum;
import com.zr.util.*;
import com.zr.xinshenstatistics.util.ResultBuildVo;
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
public class EarliersettlementServiceImpl implements EarliersettlementService {
    @Autowired
    private EarliersettlementMapper earliersettlementMapper;



    @Override
    public ResultVO<AllRecords> queryPage(EarliersettlementSelectVo earliersettlementSelectVo) {
        //查询数据
        List<Earliersettlement> earliersettlementList = earliersettlementMapper.queryPage(earliersettlementSelectVo);
        for (Earliersettlement earliersettlement:earliersettlementList) {
            Integer status = earliersettlement.getOrderStatus()==true?1:0;
            earliersettlement.setOrderStatusName(OrderNumEnum.getName(status));
        }
        //查询数量
        int count = earliersettlementMapper.queryCount(earliersettlementSelectVo);
        //把当前页,每一页的大小,总页数,总条数,放入到AllRecords
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(earliersettlementSelectVo.getPageIndex());
        allRecords.setPageSize(earliersettlementSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(earliersettlementList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO queryAll() {

        List<Riskreserve_Capitalside> riskreserve_capitalsideList = earliersettlementMapper.queryAll();
        return ResultVOBuilder.success(riskreserve_capitalsideList);

    }
    @Override
    @Transactional
    public ResultVO updateEarliersettlement(List<EarliersettlementShowVo> earliersettlementShowVoList) {
        List<String> orderNumberList = new ArrayList<>();
        //先验证数据是否存在，把存在了的数据删除掉
        for (EarliersettlementShowVo earliersettlementShowVo:earliersettlementShowVoList){
            orderNumberList.add(earliersettlementShowVo.getIdCode());
        }
        List<EarliersettlementShowVo>  earliersettlementShowVos = earliersettlementMapper.queryByIdCodes(orderNumberList);
        if(!CollectionUtils.isEmpty(earliersettlementShowVos)){

            earliersettlementMapper.deleteEarliersettlement(earliersettlementShowVos);
            earliersettlementMapper.insertEarliersettlement(earliersettlementShowVoList);

        }else{
            earliersettlementMapper.insertEarliersettlement(earliersettlementShowVoList);
        }
        return ResultVOBuilder.success(earliersettlementShowVoList);
    }


    @Override
    public ResultVO exportExcel(HttpServletResponse response, EarliersettlementSelectVo earliersettlementSelectVo)throws Exception {
        //从数据库中查询出将要导出的数据
        List<Earliersettlement> earliersettlementList = earliersettlementMapper.queryBySelectVo(earliersettlementSelectVo);
        for (Earliersettlement earliersettlement:earliersettlementList){
            earliersettlement.setOrderStatusName(OrderNumEnum.getName(earliersettlement.getOrderStatus()==true?1:0));
        }
        //限制，默认只允许导出10000条数据
        int count = earliersettlementMapper.queryCount(earliersettlementSelectVo);
        if (count>10000){
            return ResultVOBuilder.error("默认只允许导出10000条数据！请增加条件导出","500");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "提前结清模板");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("/提前结清.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", earliersettlementList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }

    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Earliersettlement> resultList, ServletOutputStream out) throws Exception {
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
    private void toResultListValueInfo(Sheet sheet, List<Earliersettlement> earliersettlementList) {
        //从第五行开始赋值
        int row_column = 4;
        //遍历数据集合
        for (Earliersettlement obj : earliersettlementList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, obj.getId() + "");
            // 给第二列编码赋值
            POIClass.toCellValue(row, 1, obj.getShenQingAmount() + "");
            // 给第3列名称赋值
            POIClass.toCellValue(row, 2, obj.getOrderNum() + "");
            // 给状态赋值
            POIClass.toCellValue(row, 3, obj.getIdCode() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getPhone() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getServiceCharge() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getPenaltyInterest() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getOrderStatus() + "");
            row_column++;
        }
    }

}

