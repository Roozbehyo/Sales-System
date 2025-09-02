package com.mftplus.model.enums;

import lombok.Getter;

@Getter
public enum BankName {
    // Governmental Banks
    MELLI("Bank Melli Iran"),
    SEPAH("Bank Sepah"),
    SADERAT("Bank Saderat Iran"),
    MASKAN("Bank Maskan"),
    KESHAVARZI("Bank Keshavarzi"),
    SANAT_MADAN("Bank Sanat o Madan (Industry & Mine Bank)"),
    REFAH("Bank Refah Kargaran"),
    POST_BANK("Post Bank Iran"),

    // Private Banks
    PARSIAN("Bank Parsian"),
    PASARGAD("Bank Pasargad"),
    SAMAN("Bank Saman"),
    KARAFARIN("Bank Karafarin"),
    KHAVARMIANEH("Bank khavarmianeh"),
    EGHTESAD_NOVIN("Bank Eghtesad Novin"),
    SARMAYEH("Bank Sarmayeh"),
    SHAHR("Bank Shahr"),
    AYANDEH("Bank Ayandeh"),
    TOURISM("Tourism Bank"),
    IRAN_ZAMIN("Bank Iran Zamin"),
    GHAVAMIN("Bank Ghavamin"),
    HEKMAT_IRANIAN("Bank Hekmat Iranian"),
    DEY("Bank Dey"),
    MEHR_IRAN("Bank Mehr Iran (Qarzolhasaneh)"),
    RESALAT("Bank Resalat");

    private final String fullName;

    BankName(String fullName) {
        this.fullName = fullName;
    }
}