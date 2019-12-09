export class RegistroMovimientos{
    
    constructor(
        public id: number,
        public ingresaProductoStock: boolean,
        public cantidad: number,
        public precioTotalMovimiento: number,
        public fechaHoraMovimiento: Date,
        public observaciones: string,
    ){}
}