package com.wwh.vo;

/**
 * 层级关系VO
 * @author u1
 *
 */
public class LevelRelationshipVO extends BaseVO{

	private static final long serialVersionUID = -3144416539525798245L;
	
	//层级关系
	private String levelRelation;

	public String getLevelRelation() {
		return levelRelation;
	}

	public void setLevelRelation(String levelRelation) {
		this.levelRelation = levelRelation;
	}

}
