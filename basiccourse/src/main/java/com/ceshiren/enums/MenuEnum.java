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

    public static MenuEnum getMenuBySelect(String select){
        for (MenuEnum menuEnum:values()) {
            if(select.equals(menuEnum.getSelect())){
                return menuEnum;
            }
        }
        return null;
    }

    public static MenuEnum getPromptBySelect(String select){
        for (MenuEnum menuEnum:values()) {
            if(select.equals(menuEnum.getPrompt())){
                return menuEnum;
            }
        }
        return null;
    }

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
