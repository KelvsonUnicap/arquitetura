package com.kelvson.order.domain;

public enum Status {
    PENDING {
        @Override
        public void next(Order order){
            order.setStatus(PAID);
        }
    },
    PAID {
        @Override
        public void next(Order order){
            order.setStatus(DELIVERED);
        }
    },
    DELIVERED {
        @Override
        public void next(Order order) {
            throw new IllegalArgumentException("Chegou ao limite");
        }
    },

    CANCELED {
        @Override
        public void next(Order order) {
            throw new IllegalArgumentException("O pedido foi cancelado. Não há nada que se possa fazer.");
        }
    };
    public abstract void next(Order order);
    public void cancel(Order order) {
        order.setStatus(CANCELED);
    }
}
