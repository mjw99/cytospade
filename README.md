# CytoSPADE Cytoscape Plugin for SPADE
This is an experimential mavenised fork with a few extra bug fixes; please see the parent project for the full details

## Prerequisites
1. [Java 1.6 SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. [git](http://git-scm.com)
1. Latest version of [Cytoscape](http://www.cytoscape.org/download.html) (tested with 2.8.1, 2.8.2)
1. [maven](http://maven.apache.org/)

## Setup and Build Process under a Debian like OS

```bash
git clone https://github.com/mjw99/cytospade.git
cd cytospade
mvn package
# Copy the resulting jar in ./target to your cyctoscape plugins directory

