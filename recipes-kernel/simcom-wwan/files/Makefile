# obj-m := hello.o

# SRC := $(shell pwd)

# all:
# 	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

# modules_install:
# 	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

# clean:
# 	rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
# 	rm -f Module.markers Module.symvers modules.order
# 	rm -rf .tmp_versions Modules.symvers

# obj-m:=simcom_wwan.o
# simcom_wwanmodule-objs:=module
# KDIR:=/lib/modules/$(shell uname -r)/build
# MAKE:=make
# default:
#         $(MAKE) -C $(KDIR) SUBDIRS=$(PWD) modules    
# clean:
#         $(MAKE) -C $(KDIR) SUBDIRS=$(PWD) clean 

obj-m := simcom_wwan.o

SRC := $(shell pwd)

all:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
	rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
	rm -f Module.markers Module.symvers modules.order
	rm -rf .tmp_versions Modules.symvers
