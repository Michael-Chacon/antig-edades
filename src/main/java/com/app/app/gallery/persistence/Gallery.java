package com.app.app.gallery.persistence;

import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.country.persistence.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeGallery;

    @Column(nullable = false)
    @NotNull
    String urlPhoto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeAntiquity")
    Antiquity antiquity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gallery gallery)) return false;
        return Objects.equals(getCodeGallery(), gallery.getCodeGallery()) && Objects.equals(getUrlPhoto(), gallery.getUrlPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeGallery(), getUrlPhoto());
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "codeGallery=" + codeGallery +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
