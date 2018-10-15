SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "(sun8i|sun50i)"

require recipes-kernel/linux/linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

LINUX_VERSION = "4.14"
LINUX_VERSION_EXTENSION = "-allwinner"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable:"

S = "${WORKDIR}/git"

PV = "4.14.75"
SRCREV = "8e6a9240b1918c31a90e5d0a02c467ca68b160c6"

SRC_URI = " \
        git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
        file://do_patch.sh \
        file://patches \
        file://${ARMBIAN_DEFCONFIG}-defconfig/defconfig \
"

do_patch_append() {
    cp ${WORKDIR}/${ARMBIAN_DEFCONFIG}-defconfig/defconfig ${WORKDIR}/defconfig
    cd ${WORKDIR}/git
    ${WORKDIR}/do_patch.sh ${WORKDIR}/patches
}

python() {
    if not d.getVar('ARMBIAN_DEFCONFIG'):
        bb.fatal("You need to set 'ARMBIAN_DEFCONFIG' in your local.conf file to 'sunxi' or 'sunxi64' depending your board.")
    else:
        bb.note("%s-defconfig/defconfig will be used for the kernel." % (d.getVar('ARMBIAN_DEFCONFIG')))
}