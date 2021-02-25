package cn.gsq.queryform.dao;

import cn.gsq.queryform.domain.CGDD;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author diao 2021/2/24
 */
@Mapper
public interface CGDDDao {

    @Select("SELECT  * ,DATEDIFF(DAY,t.承诺交货日,t.当前日期) as  超期天数\n" +
            "from\n" +
            "    (select\t\t                                dbo.Mfg_ORDMAST.OMON AS 订单号,\n" +
            "                                                   [dbo].[FS_HistoryPOLine].TransactionDate AS 创建日期,\n" +
            "                                                   --dbo.Mfg_ORDMAST.OMORGDTE AS 创建日期,\n" +
            "                                                   CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN Mfg_SDRECS.OPSEQN\n" +
            "                                                        ELSE Mfg_SDRECS.LINENUM\n" +
            "                                                       END AS 行号 ,\n" +
            "                                                   dbo.Mfg_ITMMAST.IMPN AS 料号 ,\n" +
            "                                                   dbo.Mfg_ITMMAST.IMDESC AS 描述 ,\n" +
            "                                                   CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN 0\n" +
            "                                                        ELSE Mfg_SDRECS.QTYREQ\n" +
            "                                                       END AS 订单数量 ,\n" +
            "                                                   dbo.Mfg_ITMMAST.IMUM AS 单位 ,\n" +
            "                                                   Mfg_SDRECS.ORDSTA AS 行态 ,\n" +
            "                                                   CONVERT(CHAR(10),(CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN CONVERT(DATETIME, '01/01/1980', 101)ELSE  Mfg_SDRECS.REQDUEDT END),120) AS 承诺交货日 ,\n" +
            "                                                   Mfg_SDRECS.QTYRCV AS 入库数量,\n" +
            "                                                   CONVERT(CHAR(10),getdate(),120)as  当前日期\n" +
            "     FROM    dbo.Mfg_ORDMAST\n" +
            "                 LEFT OUTER JOIN dbo.Mfg_DFSFNSF AS Mfg_SDRECS ON Mfg_SDRECS._ORDS_OwnRow = dbo.Mfg_ORDMAST._Row\n" +
            "                 LEFT OUTER JOIN dbo.Mfg_ITMMAST ON dbo.Mfg_ITMMAST._Row = Mfg_SDRECS._ITMS_OwnRow\n" +
            "         AND Mfg_SDRECS._ITMS_OwnRec = 19\n" +
            "\n" +
            "\n" +
            "                 left outer join [dbo].[FS_HistoryPOLine] on PONumber = dbo.Mfg_ORDMAST.OMON and POLineNumber =  (CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN Mfg_SDRECS.OPSEQN\n" +
            "                                                                                                                       ELSE Mfg_SDRECS.LINENUM\n" +
            "         END)\n" +
            "     WHERE   ( dbo.Mfg_ORDMAST.OMTYPE = 'P' )\n" +
            "       AND (CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN Mfg_SDRECS.CMPLNTYP\n" +
            "                 ELSE Mfg_SDRECS.ORDTYP\n" +
            "         END IS NOT null)\n" +
            "       AND (CASE WHEN Mfg_SDRECS.RECTYPE = 'D' THEN 0 ELSE Mfg_SDRECS.QTYREQ END) !=Mfg_SDRECS.QTYRCV\n" +
            "    ) t\n" +
            "where DATEDIFF(DAY,t.承诺交货日,t.当前日期) > 0 ORDER BY 超期天数 desc")
    public List<CGDD> findAll();
}
