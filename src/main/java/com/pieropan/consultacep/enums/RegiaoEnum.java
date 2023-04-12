package com.pieropan.consultacep.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RegiaoEnum {

    SUDESTE("SP,MG,ES,RJ") {
        @Override
        public String valorFrete() {
            return "7,85";
        }
    },

    SUL("PR,SC,RS") {
        @Override
        public String valorFrete() {
            return "17,30";
        }
    },

    NORTE("AM,PA,AC,RR,RO,AP,TO") {
        @Override
        public String valorFrete() {
            return "20,83";
        }
    },

    NORDESTE("MA,PI,CE,RN,PB,PE,AL,SE,BA") {
        @Override
        public String valorFrete() {
            return "15,98";
        }
    },

    CENTRO_OESTE("GO,MT,MS,DF") {
        @Override
        public String valorFrete() {
            return "12,50";
        }
    };

    private String siglasEstados;

    RegiaoEnum(String siglasEstados) {
        this.siglasEstados = siglasEstados;
    }

    public static RegiaoEnum getRegiaoEnum(String estado) {
        return Arrays.stream(RegiaoEnum.values()).filter(regiao -> regiao.getSiglasEstados().contains(estado)).findFirst().get();
    }

    public abstract String valorFrete();
}