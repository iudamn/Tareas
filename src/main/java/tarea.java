class tarea {
    private String titulo, estado, descripcion;;
    private int tiempo;

    public tarea(String titulo, String estado, int tiempo, String descripcion){
        this.titulo = titulo;
        this.estado = estado;
        this.tiempo= tiempo;
        this.descripcion = descripcion;
    }

    public void mostrar() {
        System.out.println("Título: " + titulo);
        System.out.println("Estado: " + estado);
        System.out.println("Tiempo estimado: " + tiempo);
        System.out.println("Descripción: " + descripcion);
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getTiempo(){
        return tiempo;
    }

    public String getEstado(){
        return estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }


}
