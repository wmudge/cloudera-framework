#Cloudera Framework

Provide a Cloudera development framework, including a unit test harness, client and runtime bill-of-materials and driver base class, with full coverage across the Cloudera stack, including HDFS, YARN, MR2, Hive, Spark, HBase, Impala and Solr.

##Requirements

To compile, build and package from source, this project requires:

* JDK 1.7
* Maven 3

##Install

This project can be installed to a local repository as per:

```bash
export CF_VERSION=1.1.0
export CDH_VERSION=5.4.2
git clone git@github.com:ggear/cloudera-framework.git
cd cloudera-framework
git checkout cloudera-framework-$CF_VERSION-cdh$CDH_VERSION
mvn clean install -PCMP
```

Alternatively, the module can be distributed as a binary by copying the dependencies (eg [cloudera-framework-1.0.0-cdh5.4.2](https://github.com/ggear/cloudera-framework/tree/cloudera-framework-1.0.0-cdh5.4.2/cloudera-framework-repo/cloudera-framework-repo-external/src/main/repository) into a shared lib (eg, [cloudera-cyclehire](https://github.com/ggear/cloudera-cyclehire)).

##Usage

The cloudera-framework includes an archetype allowing you to stand up a simple project and get going fast:

```bash
mvn archetype:generate \
  -DarchetypeGroupId=com.cloudera.framework.main \
  -DarchetypeArtifactId=cloudera-framework-main-archetype \
  -Dversion=1.0.0-SNAPSHOT \
  -DgroupId=com.my.company \
  -DartifactId=my-cloudera-project \
  -Dpackage="com.my.company"
cd my-cloudera-project
mvn clean install
```

##Release

To perform a release:

```bash
export CF_VERSION_RELEASE=1.1.0
export CDH_VERSION_RELEASE=5.4.2
export CF_VERSION_HEAD=1.2.0
export CDH_VERSION_HEAD=5.4.3
mvn clean
mvn release:prepare -B -DreleaseVersion=$CF_VERSION_RELEASE-cdh$CDH_VERSION_RELEASE -DdevelopmentVersion=$CF_VERSION_HEAD-cdh$CDH_VERSION_HEAD-SNAPSHOT
mvn release:clean
git checkout -b cloudera-framework-$CF_VERSION_RELEASE-cdh$CDH_VERSION_RELEASE cloudera-framework-$CF_VERSION_RELEASE-cdh$CDH_VERSION_RELEASE
mvn clean install -PCMP
git add -A cloudera-framework-repo/cloudera-framework-repo-external/src/main/repository
git commit -m "Add binaries for cloudera-framework-$CF_VERSION_RELEASE-cdh$CDH_VERSION_RELEASE"
git checkout master
mvn clean
git push --all
git tag
git branch --all
```
