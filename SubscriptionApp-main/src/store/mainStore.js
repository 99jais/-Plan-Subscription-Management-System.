import { configureStore } from '@reduxjs/toolkit';
import mainReducer from '../reducers/mainReducer';

const store = configureStore({ 
    reducer:mainReducer,
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
          serializableCheck: false,
        }),
});

export default store;