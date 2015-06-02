package cn.com.btmu.art.biz.collection.vo;

import java.util.List;

import cn.com.btmu.art.biz.collection.vo.ModHistVO;

	public class PopUpModHistVO {

	  /** 弹出窗口-修改履历 */
	  private List<ModHistVO> modHistVOList;

	  /**
	   * @return modHistVOList
	   */
	  public List<ModHistVO> getModHistVOList() {
	    return modHistVOList;
	  }

	  /**
	   * @param modHistVOList 要设置的 modHistVOList
	   */
	  public void setModHistVOList(List<ModHistVO> modHistVOList) {
	    this.modHistVOList = modHistVOList;
	  }
}
