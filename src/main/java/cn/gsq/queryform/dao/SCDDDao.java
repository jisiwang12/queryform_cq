package cn.gsq.queryform.dao;

import cn.gsq.queryform.domain.SCDD;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Mapper
public interface SCDDDao {

    /**
     * 缅甸
     * @return
     */
    @Select("SELECT  dbo.FS_MOHeader.MONumber AS 订单号 ,\n" +
            "        dbo.FS_MOLine.MOLineNumber AS 行号 ,\n" +
            "        dbo.FS_MOLine.MOLineType AS 订单类型 ,\n" +
            "        dbo.FS_MOLine.MOLineStatus AS 订单状态 ,\n" +
            "        dbo.FS_Item.ItemNumber AS 料号 ,\n" +
            "        dbo.FS_Item.ItemDescription AS 物料描述 ,\n" +
            "        dbo.FS_Item.ItemUM AS 单位 ,\n" +
            "        dbo.FS_MOLine.ItemOrderedQuantity AS 订单数量 ,\n" +
            "        dbo.FS_MOLine.ReceiptQuantity AS 入库数量 ,\n" +
            "         ( dbo.FS_MOLine.ItemOrderedQuantity - dbo.FS_MOLine.ReceiptQuantity ) AS 未结数量 ,\n" +
            "          CONVERT(CHAR(10), dbo.FS_MOLine.StartDate, 120) AS 开工日期 ,\n" +
            "         CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120) AS 完工日期,\n" +
            "         CONVERT(CHAR(10), GETDATE(), 120) AS 当前日期,\n" +
            "         DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) as 超期天数\n" +
            "         FROM    dbo.FS_MOHeader\n" +
            "                                            INNER JOIN dbo.FS_MOLine ON dbo.FS_MOHeader.MOHeaderKey = dbo.FS_MOLine.MOHeaderKey\n" +
            "                                            INNER JOIN dbo.FS_Item ON dbo.FS_MOLine.ItemKey = dbo.FS_Item.ItemKey\n" +
            "                                    where dbo.FS_MOLine.ItemOrderedQuantity !=dbo.FS_MOLine.ReceiptQuantity and dbo.FS_Item.ItemNumber !='00-1100000001'\n" +
            "                                    and dbo.FS_MOHeader.MONumber like '%MD%'\n" +
            "                                    order by DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) desc")
    public List<SCDD> findAllByMD();

    /**
     * 外协
     * @return
     */
    @Select("SELECT  dbo.FS_MOHeader.MONumber AS 订单号 ,\n" +
            "        dbo.FS_MOLine.MOLineNumber AS 行号 ,\n" +
            "        dbo.FS_MOLine.MOLineType AS 订单类型 ,\n" +
            "        dbo.FS_MOLine.MOLineStatus AS 订单状态 ,\n" +
            "        dbo.FS_Item.ItemNumber AS 料号 ,\n" +
            "        dbo.FS_Item.ItemDescription AS 物料描述 ,\n" +
            "        dbo.FS_Item.ItemUM AS 单位 ,\n" +
            "        dbo.FS_MOLine.ItemOrderedQuantity AS 订单数量 ,\n" +
            "        dbo.FS_MOLine.ReceiptQuantity AS 入库数量 ,\n" +
            "         ( dbo.FS_MOLine.ItemOrderedQuantity - dbo.FS_MOLine.ReceiptQuantity ) AS 未结数量 ,\n" +
            "          CONVERT(CHAR(10), dbo.FS_MOLine.StartDate, 120) AS 开工日期 ,\n" +
            "         CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120) AS 完工日期,\n" +
            "         CONVERT(CHAR(10), GETDATE(), 120) AS 当前日期,\n" +
            "         DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) as 超期天数\n" +
            "         FROM    dbo.FS_MOHeader\n" +
            "                                            INNER JOIN dbo.FS_MOLine ON dbo.FS_MOHeader.MOHeaderKey = dbo.FS_MOLine.MOHeaderKey\n" +
            "                                            INNER JOIN dbo.FS_Item ON dbo.FS_MOLine.ItemKey = dbo.FS_Item.ItemKey\n" +
            "                                    where dbo.FS_MOLine.ItemOrderedQuantity !=dbo.FS_MOLine.ReceiptQuantity and dbo.FS_Item.ItemNumber !='00-1100000001'\n" +
            "                                    and dbo.FS_MOHeader.MONumber not like 'Q1%' and dbo.FS_MOHeader.MONumber not like '%PG%' and dbo.FS_MOHeader.MONumber not like '%MD%' \n" +
            "                                    order by DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) desc")
    public List<SCDD> findByWX();

    /**
     * 制造
     * @return
     */
    @Select("SELECT  dbo.FS_MOHeader.MONumber AS 订单号 ,\n" +
            "        dbo.FS_MOLine.MOLineNumber AS 行号 ,\n" +
            "        dbo.FS_MOLine.MOLineType AS 订单类型 ,\n" +
            "        dbo.FS_MOLine.MOLineStatus AS 订单状态 ,\n" +
            "        dbo.FS_Item.ItemNumber AS 料号 ,\n" +
            "        dbo.FS_Item.ItemDescription AS 物料描述 ,\n" +
            "        dbo.FS_Item.ItemUM AS 单位 ,\n" +
            "        dbo.FS_MOLine.ItemOrderedQuantity AS 订单数量 ,\n" +
            "        dbo.FS_MOLine.ReceiptQuantity AS 入库数量 ,\n" +
            "         ( dbo.FS_MOLine.ItemOrderedQuantity - dbo.FS_MOLine.ReceiptQuantity ) AS 未结数量 ,\n" +
            "          CONVERT(CHAR(10), dbo.FS_MOLine.StartDate, 120) AS 开工日期 ,\n" +
            "         CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120) AS 完工日期,\n" +
            "         CONVERT(CHAR(10), GETDATE(), 120) AS 当前日期,\n" +
            "         DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) as 超期天数\n" +
            "         FROM    dbo.FS_MOHeader\n" +
            "                                            INNER JOIN dbo.FS_MOLine ON dbo.FS_MOHeader.MOHeaderKey = dbo.FS_MOLine.MOHeaderKey\n" +
            "                                            INNER JOIN dbo.FS_Item ON dbo.FS_MOLine.ItemKey = dbo.FS_Item.ItemKey\n" +
            "                                    where dbo.FS_MOLine.ItemOrderedQuantity !=dbo.FS_MOLine.ReceiptQuantity and dbo.FS_Item.ItemNumber !='00-1100000001'\n" +
            "                                    and dbo.FS_MOHeader.MONumber like 'Q1%' and dbo.FS_MOHeader.MONumber not like '%PG%' and dbo.FS_MOHeader.MONumber not like('%T')\n" +
            "                                     and dbo.FS_MOHeader.MONumber not like( '%TR') and dbo.FS_MOHeader.MONumber not like('%L') and dbo.FS_MOHeader.MONumber not like('%LR')\n" +
            "                                    order by DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) desc")
    public List<SCDD> findByZZ();


    /**
     * 品控
     * @return
     */
    @Select("SELECT  dbo.FS_MOHeader.MONumber AS 订单号 ,\n" +
            "        dbo.FS_MOLine.MOLineNumber AS 行号 ,\n" +
            "        dbo.FS_MOLine.MOLineType AS 订单类型 ,\n" +
            "        dbo.FS_MOLine.MOLineStatus AS 订单状态 ,\n" +
            "        dbo.FS_Item.ItemNumber AS 料号 ,\n" +
            "        dbo.FS_Item.ItemDescription AS 物料描述 ,\n" +
            "        dbo.FS_Item.ItemUM AS 单位 ,\n" +
            "        dbo.FS_MOLine.ItemOrderedQuantity AS 订单数量 ,\n" +
            "        dbo.FS_MOLine.ReceiptQuantity AS 入库数量 ,\n" +
            "         ( dbo.FS_MOLine.ItemOrderedQuantity - dbo.FS_MOLine.ReceiptQuantity ) AS 未结数量 ,\n" +
            "          CONVERT(CHAR(10), dbo.FS_MOLine.StartDate, 120) AS 开工日期 ,\n" +
            "         CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120) AS 完工日期,\n" +
            "         CONVERT(CHAR(10), GETDATE(), 120) AS 当前日期,\n" +
            "         DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) as 超期天数\n" +
            "         FROM    dbo.FS_MOHeader\n" +
            "                                            INNER JOIN dbo.FS_MOLine ON dbo.FS_MOHeader.MOHeaderKey = dbo.FS_MOLine.MOHeaderKey\n" +
            "                                            INNER JOIN dbo.FS_Item ON dbo.FS_MOLine.ItemKey = dbo.FS_Item.ItemKey\n" +
            "                                    where dbo.FS_MOLine.ItemOrderedQuantity !=dbo.FS_MOLine.ReceiptQuantity and dbo.FS_Item.ItemNumber !='00-1100000001'\n" +
            "                                    and dbo.FS_MOHeader.MONumber like '%PG%' and dbo.FS_MOHeader.MONumber not like '%MD%'\n" +
            "                                    order by DATEDIFF(DAY,CONVERT(CHAR(10), dbo.FS_MOLine.ScheduledDate, 120),GETDATE()) desc")
    public List<SCDD> findByPK();

}
