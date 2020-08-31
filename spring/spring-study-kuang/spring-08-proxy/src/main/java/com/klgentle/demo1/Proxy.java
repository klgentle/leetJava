package com.klgentle.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHourse();
        host.rent();
        fare();
        signAContract();
    }

    // 看房
    public void seeHourse() {
        System.out.println("中介带你去看房");
    }

    public void fare() {
        System.out.println("收中介费");
    }

    public void signAContract() {
        System.out.println("签合同");
    }
}
