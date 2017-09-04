package com.nokia.netactplus.webmonitor.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.nokia.netactplus.system.entity.NetactLab;

public interface IFMService {

	Boolean tiggerUpload(String host, String dbRootPwd, String dn);
	Page<Map<String, Object>> selectAlarmsByPage(Page<Map<String, Object>> page, String host, String condition, String orderCase);

	int alarmDelegateByKeys(String type, NetactLab netactLab, List<Long> alarmKeys, String userId);

}
