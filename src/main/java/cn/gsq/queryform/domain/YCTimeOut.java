package cn.gsq.queryform.domain;

/**
 * @author diao 2021/2/24
 */
public class YCTimeOut {
    private String 原材料号;
    private String 工单接收最后日期;
    private String 物料编号;
    private String 物料描述;
    private String 单位;
    private String 制购;
    private String 类型;
    private String 状态;
    private String 库存数量;
    private String 成本;
    private String 当前日期;
    private String 超期天数;

    public String get原材料号() {
        return 原材料号;
    }

    public void set原材料号(String 原材料号) {
        this.原材料号 = 原材料号;
    }

    public String get工单接收最后日期() {
        return 工单接收最后日期;
    }

    public void set工单接收最后日期(String 工单接收最后日期) {
        this.工单接收最后日期 = 工单接收最后日期;
    }

    public String get物料编号() {
        return 物料编号;
    }

    public void set物料编号(String 物料编号) {
        this.物料编号 = 物料编号;
    }

    public String get物料描述() {
        return 物料描述;
    }

    public void set物料描述(String 物料描述) {
        this.物料描述 = 物料描述;
    }

    public String get单位() {
        return 单位;
    }

    public void set单位(String 单位) {
        this.单位 = 单位;
    }

    public String get制购() {
        return 制购;
    }

    public void set制购(String 制购) {
        this.制购 = 制购;
    }

    public String get类型() {
        return 类型;
    }

    public void set类型(String 类型) {
        this.类型 = 类型;
    }

    public String get状态() {
        return 状态;
    }

    public void set状态(String 状态) {
        this.状态 = 状态;
    }

    public String get库存数量() {
        return 库存数量;
    }

    public void set库存数量(String 库存数量) {
        this.库存数量 = 库存数量;
    }

    public String get成本() {
        return 成本;
    }

    public void set成本(String 成本) {
        this.成本 = 成本;
    }

    public String get当前日期() {
        return 当前日期;
    }

    public void set当前日期(String 当前日期) {
        this.当前日期 = 当前日期;
    }

    public String get超期天数() {
        return 超期天数;
    }

    public void set超期天数(String 超期天数) {
        this.超期天数 = 超期天数;
    }

    @Override
    public String toString() {
        return "YCTimeOut{" +
                "原材料号='" + 原材料号 + '\'' +
                ", 工单接收最后日期='" + 工单接收最后日期 + '\'' +
                ", 物料编号='" + 物料编号 + '\'' +
                ", 物料描述='" + 物料描述 + '\'' +
                ", 单位='" + 单位 + '\'' +
                ", 制购='" + 制购 + '\'' +
                ", 类型='" + 类型 + '\'' +
                ", 状态='" + 状态 + '\'' +
                ", 库存数量='" + 库存数量 + '\'' +
                ", 成本='" + 成本 + '\'' +
                ", 当前日期='" + 当前日期 + '\'' +
                ", 超期天数='" + 超期天数 + '\'' +
                '}';
    }
}
