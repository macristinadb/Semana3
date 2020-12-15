package negocio;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    private String nombreCompleto;
    private String fechaNac;
    private String telefono;
    private String email;
    private String contacto;


    public Cliente(String nombreCompleto, String fechaNac, String telefono, String email, String contacto) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.email = email;
        this.contacto = contacto;
    }


    public Cliente(Parcel parcel){
        String[] data = new String[5];
        parcel.readStringArray(data);
        this.nombreCompleto = data[0];
        this.fechaNac = data[1];
        this.telefono = data[2];
        this.email = data[3];
        this.contacto = data[4];
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{
                this.nombreCompleto,
                this.fechaNac,
                this.telefono,
                this.email,
                this.contacto
        });
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Cliente createFromParcel(Parcel parcel) {
            return new Cliente(parcel);
        }

        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }

    };

}

