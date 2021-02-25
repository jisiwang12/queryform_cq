package cn.gsq.queryform.dao;

import cn.gsq.queryform.domain.YCTimeOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Mapper
public interface YCTimeOutDao {
    @Select("select *, CONVERT(CHAR(10),getdate(),120) as 当前日期, DATEDIFF(DAY,a.工单接收最后日期, GETDATE()) AS  超期天数\n" +
            "from\n" +
            "    (select  ItemNumber as 原材料号, CONVERT(CHAR(10),max(TransactionDate),120) as 工单接收最后日期\n" +
            "     from [FSDBKK].[dbo].[FS_HistoryPOReceipt] group by ItemNumber\n" +
            "    ) a\n" +
            "        LEFT JOIN\n" +
            "    (SELECT  dbo.FS_Item.ItemNumber AS 物料编号 ,\n" +
            "             dbo.FS_Item.ItemDescription AS 物料描述 ,\n" +
            "             dbo.FS_Item.ItemUM AS 单位 ,\n" +
            "             dbo.FS_Item.MakeBuyCode AS 制购 ,\n" +
            "             dbo.FS_Item.ItemType AS 类型 ,\n" +
            "             dbo.FS_Item.ItemStatus AS 状态 ,\n" +
            "             --dbo.FS_ItemInventory.Stockroom AS 库 ,\n" +
            "             --LTRIM(RTRIM(dbo.FS_ItemInventory.Bin)) AS 位 ,\n" +
            "             --dbo.FS_ItemInventory.InventoryCategory AS 库位状态 ,\n" +
            "             --dbo.FS_ItemInventory.LotNumber ,\n" +
            "             ROUND(sum(dbo.FS_ItemInventory.InventoryQuantity),4) AS 库存数量 ,\n" +
            "             CONVERT(decimal(18, 4),sum(dbo.FS_ItemCost.TotalRolledCost)) AS 成本\n" +
            "     FROM    dbo.FS_Item\n" +
            "                 LEFT OUTER JOIN dbo.FS_ItemCost ON dbo.FS_Item.ItemKey = dbo.FS_ItemCost.ItemKey\n" +
            "                 RIGHT OUTER JOIN dbo.FS_ItemInventory ON dbo.FS_Item.ItemKey = dbo.FS_ItemInventory.ItemKey\n" +
            "                 LEFT OUTER JOIN dbo.FS_InventoryLocation ON dbo.FS_ItemInventory.Stockroom = dbo.FS_InventoryLocation.Stockroom\n" +
            "         AND dbo.FS_ItemInventory.Bin = dbo.FS_InventoryLocation.Bin\n" +
            "     WHERE  ( CONVERT(decimal(18, 6),dbo.FS_ItemInventory.InventoryQuantity ) <> 0 ) AND\n" +
            "         ( dbo.FS_ItemCost.CostType = '0' ) and dbo.FS_Item.MakeBuyCode !='M'\n" +
            "     group by dbo.FS_Item.ItemNumber, dbo.FS_Item.ItemDescription, dbo.FS_Item.ItemUM,dbo.FS_Item.MakeBuyCode\n" +
            "            ,dbo.FS_Item.ItemStatus,dbo.FS_Item.ItemType\n" +
            "    )b\n" +
            "    on a.原材料号=b.物料编号\n" +
            "where b.物料编号 is not null  order by a.工单接收最后日期")
    public List<YCTimeOut> findAll();
}
