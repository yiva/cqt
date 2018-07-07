package org.yiva.cqt.utils;

public enum JounalCategory {
	all("all", "所有台账"), 
	one("one", "一对一"), 
	gongyi("gongyi", "公益金"), 
	zanshang("zanshang", "赞赏款"),
	xiangxue("xiangxue", "奖学金"), 
	zhiliu("zhiliu", "滞留助学金收支"), 
	other("other", "其他"), 
	alone("alone", "独立流水"),
	wqtixian("wqtixian", "微信提现流水"), 
	wqgongzhong("wqgongzhong", "微信公众号入账"), 
	yuebao("yuebao", "余额宝收益"),
	daizhu("daizhu", "待助"), 
	jounal("jounal", "流水账");

	private String name;
	private String category;

	private JounalCategory(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * 获取中文类型名
	 * @param index
	 * @return
	 */
    public static String getNameByEn(String name) {
        for (JounalCategory c : JounalCategory.values()) {
            if (name.equals(c.getName())) {
                return c.category;
            }
        }
        return null;
    }

}
