package com.zhdtedu.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sf.json.JSONObject;

public class ReturnMsg {

		private Map rdata;
		
		private Map ro;

		public ReturnMsg() {
			super();
			rdata = new HashMap();
			ro = new HashMap();
		}

		public String toJSONString() {
			this.ro.put("rdata", rdata);
			// return ro.toString();
			try {
				JSONObject json = new JSONObject();
				json.putAll(ro);
				return json.toString();
			} catch (Exception e) {
				e.printStackTrace();
				this.exception(e);
				return ro.toString();
			}

		}

		public JSONObject toJSONObject() {
			JSONObject jsonRo = new JSONObject();
			Iterator iter = this.ro.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				jsonRo.put(key, this.ro.get(key));
			}

			JSONObject jsonRdata = new JSONObject();
			Iterator iterRdata = this.rdata.keySet().iterator();
			while (iterRdata.hasNext()) {
				String key = (String) iterRdata.next();
				jsonRdata.put(key, this.rdata.get(key));
			}
			jsonRo.put("rdata", jsonRdata);
			return jsonRo;
		}

		public void putRdata(String key, Object val) {
			this.rdata.put(key, val);
		}

		public void putRootData(String key, Object val) {
			this.ro.put(key, val);
		}

		public void putAllRdata(Map<String, Object> m) {
			for (String key : m.keySet()) {
				this.rdata.put(key, m.get(key));
			}
		}

		public ReturnMsg success() {
			return this.success("success");
		}

		public ReturnMsg success(String msg) {
			ro.put("success", true);
			ro.put("status", "1");
			ro.put("type", "info");
			ro.put("msg", msg);
			return this;
		}

	public ReturnMsg setPageInfo(SearchCondition sc) {
		ro.put("pageTotal",sc.getPageTotal());
		ro.put("pageSize",sc.getPageSize());
		ro.put("pageNo",sc.getPageNo());
		return this;
	}

		public ReturnMsg exception(Exception e) {
			ro.put("success", false);
			ro.put("status", "2");
			ro.put("msg", e.getMessage());
			ro.put("type", "error");
			ro.put("exception", e.getClass().toString());
			if(e instanceof IllegalArgumentException) {
				ro.put("msg", "无效的参数！");
			}
			return this;
		}
}
