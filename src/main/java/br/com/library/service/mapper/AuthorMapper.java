package br.com.library.service.mapper;

import br.com.library.domain.*;
import br.com.library.service.dto.AuthorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Author} and its DTO {@link AuthorDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {


    @Mapping(target = "books", ignore = true)
    @Mapping(target = "removeBooks", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    default Author fromId(Long id) {
        if (id == null) {
            return null;
        }
        Author author = new Author();
        author.setId(id);
        return author;
    }
}
