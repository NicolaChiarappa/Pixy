package it.nicolachiarappa.mappers;

public interface Mapper <Model, DTO>{

    public  DTO toDTO (Model model);


    public  Model toModel(DTO dto);

}
