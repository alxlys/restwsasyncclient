package org.cxf.demo.restasyncclient.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author olysenko
 */
@XmlRootElement
public class ChecksList {

   private List<Check> checkList;

   public List<Check> getCheckList() {
      return checkList;
   }

   public void setCheckList(List<Check> checkList) {
      this.checkList = checkList;
   }
}
