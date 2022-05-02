package ru.forum.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "post")
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String description;

        @Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
        private Calendar created;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Calendar getCreated() {
                return created;
        }

        public void setCreated(Calendar created) {
                this.created = created;
        }
}
