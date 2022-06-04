
#This function removes everything under /boot/
#
my_empty_boot() {
    rm -rf ${IMAGE_ROOTFS}/boot/*;
}

ROOTFS_POSTINSTALL_COMMAND ?= "my_empty_boot;"
