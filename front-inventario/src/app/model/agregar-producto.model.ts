export class AgregarProducto{
        constructor(
                public nombreProducto: string,
                public tipoProducto: string,
                public precioProducto: number,
                public creadoComunidad: boolean,
                public cantidad: number,
                public descripcion: string
        ){}
}