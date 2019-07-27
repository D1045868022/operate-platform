package com.zr.yuqiliebiao.service.impl;

import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ExportUtil;
import com.zr.xinshenstatistics.util.POIClass;
import com.zr.yuqiliebiao.mapper.YuqiMapper;
import com.zr.yuqiliebiao.pojo.Overduelist;
import com.zr.yuqiliebiao.pojo.OverduelistVo;
import com.zr.yuqiliebiao.service.YuqiService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class YuqiServiceImpl implements YuqiService {

    @Autowired
    private YuqiMapper yuqiMapper;
    /**
     * 分页查询 附带模糊查询 并且统一异常处理
     * @return
     */

    @Override
    public ResultVO queryByPage(OverduelistVo overduelistVo) {
        List<Overduelist> overduelists = yuqiMapper.queryPage(overduelistVo);
        //查询数量
        int count = yuqiMapper.queryCount(overduelistVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(overduelistVo.getPageIndex());
        allRecords.setPageSize(overduelistVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(overduelists);
        return ResultVOBuilder.success(allRecords);
    }
    /**
     * 银行传输过来数据入库
     * @return
     */
    @Override
    @Transactional
    public ResultVO overdueList(List<Overduelist> overduelists) {
        List<String> idCodes = new ArrayList<>();
        Date nowDate = new Date();
        for (Overduelist overdueListSelectVo:overduelists){
            idCodes.add(overdueListSelectVo.getIdCode());
            overdueListSelectVo.setCreateTime(nowDate);
        }
        //根据资方的身份证号查询数据库是否存在数据
        List<OverduelistVo> overduelists1 = yuqiMapper.queryByIdCodes(idCodes);
        List<String> newIdCodes = new ArrayList<>();

        for (OverduelistVo overdueListSelectVo:overduelists1){
            newIdCodes.add(overdueListSelectVo.getIdCode());
        }
        //如果存在数据，删除掉原有数据
        yuqiMapper.deleteByIdCodes(newIdCodes);
        //重新插入银行数据
        yuqiMapper.insertOverduList(overduelists);

        return ResultVOBuilder.success(overduelists);
    }
    /**
     *  //1.定义一个导出模板
     //2.从数据库中查询出将要导出的数据
     //3.把从数据库中查询出的数据赋值给导出模板
     //4.对需要转化的数据进行转化
     //5.在浏览器生成一个文件
     */
    @Override
    public ResultVO exportExcel(HttpServletResponse response, OverduelistVo overduelistVo) throws Exception {
        List<Overduelist> xinshenstatisticsList = yuqiMapper.queryBySelectVo(overduelistVo);
        System.out.println("长度"+xinshenstatisticsList.size());

        //限制,导出10000数据
        int totalNum = yuqiMapper.queryCount(overduelistVo);
        if(totalNum>10000){
            return ResultVOBuilder.error("默认导出10000条数据","500");
        }
        //3.把从数据库中查询出的数据赋值给导出模
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/导出.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", xinshenstatisticsList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }



    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Overduelist> resultList, ServletOutputStream out) throws Exception {

        //POI读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if(sheet != null){
            //向sheet1中赋值，设置样式
            toResultListValueInfo(sheet, resultList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭POI方法
        wb.close();
    }


    /**
     * 插入excel表中项目信息
     *
     * @param sheet
     */
    private void toResultListValueInfo(Sheet sheet, List<Overduelist> overdueSelectVoList) {
        //遍历数据集合
        int row_column = 4;
        //遍历数据集合
        Integer number = 1;
        for(Overduelist obj : overdueSelectVoList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row, 0, (number ++) + "");
            //商户姓名
            POIClass.toCellValue(row, 1, obj.getMerchantName() + "");
            //姓名
            POIClass.toCellValue(row, 2, obj.getName()+"");
            //逾期日期
            POIClass.toCellValue(row, 3, obj.getPhone()+"");
            //逾期天数
//            POIClass.toCellValue(row, 4, obj.getOverdueDay() + "");
            //逾期总金额
            POIClass.toCellValue(row, 5, obj.getOverdueAmount() + "");
            //逾期本金
//            POIClass.toCellValue(row, 6, obj.getOverduePrincipalInterest() + "");
            //状态
//            POIClass.toCellValue(row, 7, obj.getStatus() + "");
            //利息
//            POIClass.toCellValue(row, 8, "");
            //罚息
//            POIClass.toCellValue(row, 9, obj.getPenaltyInterest() + "");
            //课程
//            POIClass.toCellValue(row, 10, obj.getMyCourse() + "");
            //销售
//            POIClass.toCellValue(row, 11, "");
            row_column++;
        }
    }
}
