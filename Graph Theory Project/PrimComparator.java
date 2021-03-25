import java.util.*;
public class PrimComparator implements Comparator<Path>{
  public int compare(Path p1, Path p2) {
    int wp1 = p1.getLastWeight();
    int wp2 = p2.getLastWeight();
    int toRet = 0;
    if (wp1 > wp2) {
      toRet =1;
    }else if(wp2 > wp1){
      toRet = -1;
    }else{
      toRet = 0;
    }
    return toRet;
  }
}
