package com.ivaaaak.client.Data;


import java.util.Objects;

    public class Coordinates {

        private Integer x = null; //Максимальное значение поля: 172, Поле не может быть null
        private Double y = null; //Поле не может быть null

        public void setY(Double y) {
            this.y = y;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return "Coordinates{"
                    + "x=" + x
                    + ", y=" + y
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinates that = (Coordinates) o;
            return Objects.equals(x, that.x) && Objects.equals(y, that.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

