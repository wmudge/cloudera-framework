package com.cloudera.framework.main.test;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class BaseTestTest {

  @Test
  public void testPathHDFS() {
    Assert.assertEquals(BaseTest.PATH_HDFS, BaseTest.getPathHDFS(""));
    Assert.assertEquals(BaseTest.PATH_HDFS, BaseTest.getPathHDFS("/"));
    Assert.assertEquals(BaseTest.PATH_HDFS, BaseTest.getPathHDFS("//"));
    Assert.assertEquals(BaseTest.PATH_HDFS + "/tmp",
        BaseTest.getPathHDFS("tmp"));
    Assert.assertEquals(BaseTest.PATH_HDFS + "/tmp",
        BaseTest.getPathHDFS("/tmp"));
    Assert.assertEquals(BaseTest.PATH_HDFS + "/tmp",
        BaseTest.getPathHDFS("//tmp"));
    Assert.assertEquals(BaseTest.PATH_HDFS + "/tmp",
        BaseTest.getPathHDFS("///tmp"));
    Assert.assertEquals(BaseTest.PATH_HDFS + "/tmp/tmp",
        BaseTest.getPathHDFS("///tmp//tmp"));
  }

  @Test
  public void testPathLocal() {
    String localDir = new File(".").getAbsolutePath();
    localDir = localDir.substring(0, localDir.length() - 2);
    Assert.assertEquals(localDir, BaseTest.getPathLocal(""));
    Assert.assertEquals(localDir, BaseTest.getPathLocal("/"));
    Assert.assertEquals(localDir, BaseTest.getPathLocal("//"));
    Assert.assertEquals(localDir + "/tmp", BaseTest.getPathLocal("tmp"));
    Assert.assertEquals(localDir + "/tmp", BaseTest.getPathLocal("/tmp"));
    Assert.assertEquals(localDir + "/tmp", BaseTest.getPathLocal("//tmp"));
    Assert.assertEquals(localDir + "/tmp", BaseTest.getPathLocal("///tmp"));
    Assert.assertEquals(localDir + "/tmp/tmp",
        BaseTest.getPathLocal("///tmp//tmp"));
  }

}