package com.yu_pharm.model;

import java.util.Date;

public class Recipe {
	private int recId;
	private int drugId;
	private int userId;
	private Date expDate;
	private int recipeCount;

	public Recipe(int recId, int drugId, int userId, Date expDate) {
		this.recId = recId;
		this.drugId = drugId;
		this.userId = userId;
		this.expDate = expDate;
	}

	public Recipe(int drugId, int userId, Date expDate, int recipeCount) {
		this.drugId = drugId;
		this.userId = userId;
		this.expDate = expDate;
		this.recipeCount = recipeCount;
	}

	public Recipe() {
	}

	public Recipe(int recId) {
		this.recId = recId;
	}

	public Recipe(int recId, int drugId, int userId, Date expDate, int recipeCount) {
		this.recId = recId;
		this.drugId = drugId;
		this.userId = userId;
		this.expDate = expDate;
		this.recipeCount = recipeCount;
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getRecipeCount() {
		return recipeCount;
	}

	public void setRecipeCount(int recipeCount) {
		this.recipeCount = recipeCount;
	}
}

