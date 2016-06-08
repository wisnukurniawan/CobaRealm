package com.wisnu.myapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by private on 05/06/2016.
 */
public class User extends RealmObject {
    @PrimaryKey
    private long id;

    private String nama;
    private String daerah;
    private String noHp;
    private String ahli;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAhli() {
        return ahli;
    }

    public void setAhli(String ahli) {
        this.ahli = ahli;
    }
}
