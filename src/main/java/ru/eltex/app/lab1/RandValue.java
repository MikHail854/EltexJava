package ru.eltex.app.lab1;

import java.util.Random;

public class RandValue {
    private String [] NamePhone = {"Nokia", "Samsung", "Apple", "Xiaomi", "Philips", "Meizu", "Honor"};
    private String [] NameSmartphone = {"Nokia", "Samsung", "Apple", "Xiaomi", "Philips", "Meizu", "Honor"};
    private String [] TheTablet = {"Nokia", "Samsung", "Apple", "Xiaomi", "Philips", "Meizu", "Honor"};
    private String [] Firm = {"Россия", "Китай", "США", "Индия", "Чехия", "Япония"};
    private String [] Model = {"2017 года","2018 года", "2019 года"};
    private String [] OS = {"Android", "IOS"};

    private String [] VideoProcessor = {"Qualcomm", "MediaTek", "HiSilicon Kirin", "Intel", "NVIDIA Tegra", "Exynos"};
    private String [] ScreenResolution = {"480*800" , "540*960", "720*1280", "1080*1920", "2560*1440"};


    private String [] TypeOfShell = {"классический", "раскладушка"};
    private String [] TypeSIMCard = {"micro-SIM", "обычная"};
    private String [] AmountSIM = {"1", "2"};

    String RandTypeOfShell(){
        Random random = new Random();
        return TypeOfShell[random.nextInt(2)];
    }

    String RandTypeSIMCard(){
        Random random = new Random();
        return TypeSIMCard[random.nextInt(2)];
    }

    String RandAmountSIM(){
        Random random = new Random();
        return AmountSIM[random.nextInt(2)];
    }
    String RandScreenResolution(){
        Random random = new Random();
        return ScreenResolution[random.nextInt(5)];
    }

    String RandVideoProcessor(){
        Random random = new Random();
        return VideoProcessor[random.nextInt(6)];
    }

    String RandNamePhone(){
        Random random = new Random();
        return NamePhone[random.nextInt(7)];
    }

    String RandNameSmartphone(){
        Random random = new Random();
        return NameSmartphone[random.nextInt(7)];
    }

    String RandTheTablet(){
        Random random = new Random();
        return TheTablet[random.nextInt(7)];
    }

    String RandFirm(){
        Random random = new Random();
        return Firm[random.nextInt(6)];
    }

    String RandModel(){
        Random random = new Random();
        return Model[random.nextInt(3)];
    }

    String RandOS(){
        Random random = new Random();
        return OS[random.nextInt(2)];
    }
}
