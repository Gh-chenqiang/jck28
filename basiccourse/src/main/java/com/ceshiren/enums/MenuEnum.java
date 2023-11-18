package com.ceshiren.enums;

/**
 * @Author chenqiang
 * @create 2023/11/5 23:27
 */
public enum MenuEnum {
    TITLE("","--------欢迎来到学员信息管理系统--------\n"),
    SHOW("1","根据学号查看学员信息\n"),
    ADD("2","添加学员\n"),
    DELETE("3","根据学号删除学员后，查看所有学员信息\n"),
    EXIT("4","退出系统\n");
    private final String select;
    private final String prompt;
    MenuEnum(String select, String prompt){
        this.select=select;
        this.prompt=prompt;
    }
    public String getSelect(){
        return select;
    }
    public String getPrompt(){return prompt;}

    /**
     * 通过选项获取学员系统文案
     * @param select
     * @return
     */
    public static String getPromptBySelect(String select){
        for (MenuEnum menuEnum:values()) {
            if(select.equals(menuEnum.getSelect())){
                return menuEnum.prompt;
            }
        }
        return null;
    }

    /**
     * 查询返回学员系统目录
     * @return
     */
    public static StringBuffer getMenu() {
        StringBuffer sb=new StringBuffer();
        for (MenuEnum menuEnum:values()
             ) {
            sb.append(menuEnum.getSelect())
              .append("  ")
              .append(menuEnum.getPrompt());
        }
        return sb;
    }
}
