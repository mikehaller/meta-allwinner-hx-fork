SUMMARY = "MQTT Camera service"
DESCRIPTION = "MQTT Camera service"
HOMEPAGE = ""
SECTION = "console/network"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

SRC_URI = "git://github.com/bameofme/mqtt.git;protocol=http;branch=rework"

SRCREV = "${AUTOREV}"

DEPENDS = "curl paho-mqtt-cpp ffmpeg jpeg libv4l rapidjson"
RDEPENDS_${PN} = "paho-mqtt-cpp"

inherit cmake

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install_append() {
    rm -rf ${D}/usr/share
}
