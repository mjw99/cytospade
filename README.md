# CytoSPADE Cytoscape Plugin for SPADE
This is an experimential mavenised fork with a few extra bug fixes; please see the parent project for the full details

## Setup and Build Process under a Debian like OS

```bash
# Install required packages
sudo apt-get install git maven openjdk-6-jdk

# Clone and build
git clone https://github.com/mjw99/cytospade.git
cd cytospade
mvn package

# Copy the resulting jar in ./target to your cyctoscape plugins directory

