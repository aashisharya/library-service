package com.omniwyse.library.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "BOOK_RECOMENDATION")
public class BookRecomendBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "recomend_criteria")
	private String criteria;
	@Column(name = "recomend_type")
	private String type;
	@Column(name = "display_text")
	private String displayText;
	@Type(type = "yes_no")
	@Column(name = "display_on_web")
	private boolean displayOnWeb;
	@Column(name = "order_no", nullable = false)
	private boolean orderNO;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO user;

	public long getId() {
		return id;
	}

	public String getCriteria() {
		return criteria;
	}

	public String getType() {
		return type;
	}

	public String getDisplayText() {
		return displayText;
	}

	public boolean isDisplayOnWeb() {
		return displayOnWeb;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public void setDisplayOnWeb(boolean displayOnWeb) {
		this.displayOnWeb = displayOnWeb;
	}

	public boolean isOrderNO() {
		return orderNO;
	}

	public void setOrderNO(boolean orderNO) {
		this.orderNO = orderNO;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

}
