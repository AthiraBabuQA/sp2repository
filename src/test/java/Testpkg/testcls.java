package Testpkg;

import org.testng.annotations.Test;

import basepkg.Basecls;
import pagepkg.Pagecls;

public class testcls extends Basecls{
@Test
public void test() throws Exception {
	Pagecls ob=new Pagecls(driver);
	ob.search();
	ob.product();
	ob.titleverification();
	ob.windowhandler();
}
}
