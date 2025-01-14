FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://eth0.network \
    file://wlan0.network \
    file://systemd-udevd.service \
"

PACKAGECONFIG:append = " networkd resolved"

do_install:append() {
	install -m 0644 ${WORKDIR}/eth0.network ${D}${sysconfdir}/systemd/network
	install -m 0644 ${WORKDIR}/wlan0.network ${D}${sysconfdir}/systemd/network
	install -m 0644 ${WORKDIR}/systemd-udevd.service ${D}${sysconfdir}/systemd/system/
}
