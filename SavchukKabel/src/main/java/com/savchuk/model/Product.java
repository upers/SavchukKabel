package com.savchuk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name = "id", nullable=false, insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "meta_title")
	private String metatTitle;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "article")
	private String article;

	@Column(name = "meta_description")
	private String metaDescription;

	@Column(name = "meta_keywords")
	private String metaKeyWords;

	@Column(name = "name_translit")
	private String nameTranslit;

	@Column(name = "img")
	private String image;

	@Column(name = "characteristics")
	private String characteristic;

	@Column(name = "description")
	private String description;

	@Column(name = "current_load")
	private String currentLoad;

	@ManyToOne
	@JoinColumn(name="category_id", insertable = false, updatable = false, nullable = false)
	private Category category;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "unit_id")
	private Unit unit;

	public Product() {
	}
	
	public Product(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getMetatTitle() {
		return metatTitle;
	}

	public void setMetatTitle(String metatTitle) {
		this.metatTitle = metatTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

	public String getNameTranslit() {
		return nameTranslit;
	}

	public void setNameTranslit(String nameTranslit) {
		this.nameTranslit = nameTranslit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getCurrentLoad() {
		return currentLoad;
	}

	public void setCurrentLoad(String currentLoad) {
		this.currentLoad = currentLoad;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category parentCategory) {
		this.category = parentCategory;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", nameTranslit=" + nameTranslit + "]";
	}
}
