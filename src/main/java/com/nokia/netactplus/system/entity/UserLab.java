package com.nokia.netactplus.system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


/**
 * <p>
 * 鐢ㄦ埛lab琛
 * </p>
 *
 * @author mpthink
 * @since 2017-05-05
 */
public class UserLab extends Model<UserLab> {

    private static final long serialVersionUID = 1L;

    /**
     * 涓婚敭
     */
	private Long id;
    /**
     * 鐢ㄦ埛ID
     */
	private Long userId;
    /**
     * Lab ID
     */
	private Long labId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	@Override
	public String toString(){
		return "UserLab [id=" + id + ", userId=" + userId + ", labId=" + labId + "]";
	}
}
