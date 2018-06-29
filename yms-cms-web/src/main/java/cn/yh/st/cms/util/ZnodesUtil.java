package cn.yh.st.cms.util;

import java.util.ArrayList;
import java.util.List;

import cn.yh.st.cms.domain.CmsAuth;
import cn.yh.st.common.domain.Znodes;

public class ZnodesUtil {
	/**
	 * 
	 * @param list
	 */
	public static List<Znodes> createZnodes(List<CmsAuth> list, List<Long> listRole) {
		List<Znodes> lz = new ArrayList<Znodes>();
		for (int i = 0; i < list.size(); i++) {
			CmsAuth auth = list.get(i);
			Znodes nodes = new Znodes();
			nodes.setId(auth.getId().intValue());
			nodes.setName(auth.getName());
			nodes.setOpen(true);
			nodes.setpId(auth.getpId());
			if (listRole.contains(auth.getId())) {
				nodes.setChecked(true);
			}
			lz.add(nodes);
		}
		return lz;
	}
}
