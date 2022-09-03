import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;



public class Principal {
    public static Connection conn;
    public static void main(String[] args) throws ParseException {
        conectar_bd();
        menu_principal();

    }
    public static void menu_principal() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("**MENU PRINCIPAL**");
        System.out.println("Seleccione una opcion: ");
        System.out.println(" 1.- Producto");
        System.out.println("  2.- Cliente");
        System.out.println("    3.- Proveedor");
        System.out.println("    4.- Intencion de compra");
        System.out.println("     5.- Bicicleta");
        System.out.println("      6.- Motocicleta");
        System.out.println("       7.- Salir");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int opcion1 = Integer.parseInt(sc.nextLine());
        switch (opcion1) {
            case (1):
                System.out.println("Opciones para Producto: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                int opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_productos();
                    case 2 -> nuevo_producto();
                    case 3 -> actualizar_producto();
                    case 4 -> borrar_producto();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (2):
                System.out.println("Opciones para Cliente: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_Cliente();
                    case 2 -> nuevo_cliente();
                    case 3 -> actualizar_cliente();
                    case 4 -> borrar_cliente();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (3):
                System.out.println("Opciones para Proveedor: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_proveedor();
                    case 2 -> nuevo_proveedor();
                    case 3 -> actualizar_proveedor();
                    case 4 -> borrar_proveedor();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (4):
                System.out.println("Opciones para Intencion de compra: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_intencion();
                    case 2 -> nueva_intencion();
                    case 3 -> actualizar_intencion();
                    case 4 -> borrar_intencion();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (5):
                System.out.println("Opciones para Bicicleta: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_bicicleta();
                    case 2 -> nueva_bicicleta();
                    case 3 -> actualizar_bicicleta();
                    case 4 -> borrar_bicicleta();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (6):
                System.out.println("Opciones para Motocicleta: ");
                System.out.println(" 1.- Listar");
                System.out.println("  2.- Crear");
                System.out.println("   3.- Actualizar");
                System.out.println("    4.- Borrar");
                opcion2 = Integer.parseInt(sc.nextLine());

                switch (opcion2) {
                    case 1 -> listar_motocicleta();
                    case 2 -> nueva_motocicleta();
                    case 3 -> actualizar_motocicleta();
                    case 4 -> borrar_motocicleta();
                    default -> System.out.println("Opcion incorrecta!");
                }
            case (7):
                break;
        }
    }

    public static void submenu(String opcion2) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" L.- Listar");
        System.out.println("  C.- Crear");
        System.out.println("   A.- Actualizar");
        System.out.println("    E.- Eliminar");
        opcion2 = sc.nextLine();
    }



    //-----------Base de datos----------
    public static void conectar_bd() {

        String user = "root";
        String password = "1234567";
        String link = "jdbc:mysql://localhost:3306/mintic_r4";


        /*try {
            Class.forName("com.mysql.cj.jdbc.Drivers");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            conn = DriverManager.getConnection(link, user, password);
            if (conn != null) {
                System.out.println("BASE CONECTADA!");
            } else {
                System.out.println("OJO NO CONECTADO!!!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("el severo");
        }
    }
//========================  CREAR ====================================

    public static void guardar_cliente(String alias_cliente, String nombre, String apellido, String email, String celular, int contrasenia, Date fecha_de_nacimiento_cliente) {
        String cliente_sql = "INSERT INTO Cliente  VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(cliente_sql);
            comando.setString(1, alias_cliente);
            comando.setString(2, nombre);
            comando.setString(3, apellido);
            comando.setString(4, email);
            comando.setString(5, celular);
            comando.setInt(6, contrasenia);
            comando.setDate(7, fecha_de_nacimiento_cliente);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            ex.printStackTrace();
        }
    }

    public static void nuevo_cliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Username: ");
        String alias_cliente = sc.nextLine();
        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese Email: ");
        String email = sc.nextLine();
        System.out.println("Ingrese numero de celular: ");
        String celular = sc.nextLine();
        System.out.println("Ingrese Contraseña: ");
        int contrasenia = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese Fecha de nacimiento: ");
        String fecha_de_nacimiento_string = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fecha_de_nacimiento_cliente = sdf.parse(fecha_de_nacimiento_string);
            guardar_cliente(alias_cliente, nombre, apellido, email, celular, contrasenia, new Date(fecha_de_nacimiento_cliente.getTime()));

        } catch (Exception error) {
            System.out.println("Falla en conversion de fecha");
        }
    }

    public static void guardar_producto(int id_producto, String nombre_fabricante, int precio) {
        String producto_sql = "INSERT INTO Producto VALUES (?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(producto_sql);
            comando.setInt(1, id_producto);
            comando.setString(2, nombre_fabricante);
            comando.setInt(3, precio);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            ex.printStackTrace();
        }
    }

    public static void nuevo_producto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id del producto: ");
        int id_producto = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese nombre del fabricante: ");
        String nombre_fabricante = sc.nextLine();//esta linea se salta y queda vacia!!!!!
        System.out.println("Ingrese Precio: ");
        int precio = sc.nextInt();
        guardar_producto(id_producto, nombre_fabricante, precio);
    }

    public static void guardar_proveedor(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        String proveedor_sql = "INSERT INTO Proveedor VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(proveedor_sql);
            comando.setInt(1, prov_id);
            comando.setString(2, prov_nombre);
            comando.setString(3, prov_direccion);
            comando.setString(4, prov_telefono);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            ex.printStackTrace();
        }
    }

    public static void nuevo_proveedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id del Proveedor: ");
        int prov_id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese nombre del proveedor: ");
        String prov_nombre = sc.nextLine();
        System.out.println("Ingrese direccion: ");
        String prov_direccion = sc.nextLine();
        System.out.println("Ingrese teléfono: ");
        String prov_telefono = sc.nextLine();
        guardar_proveedor(prov_id, prov_nombre, prov_direccion, prov_telefono);
    }

    public static void guardar_bicicleta(int id_bicicleta, int anio_construccion, int bici_id_producto) {
        String proveedor_sql = "INSERT INTO Bicicleta VALUES (?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(proveedor_sql);
            comando.setInt(1, id_bicicleta);
            comando.setInt(2, anio_construccion);
            comando.setInt(3, bici_id_producto);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos de bicicleta");
            ex.printStackTrace();
        }
    }

    public static void nueva_bicicleta() {
        System.out.println("Primero debe crear el producto");
        nuevo_producto();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id de la bicicleta: ");
        int id_bicicleta = sc.nextInt();
        System.out.println("Ingrese año de construcción: ");
        int anio_construccion = sc.nextInt();
        System.out.println("Ingrese id de PRODUCTO: ");
        int bici_id_producto = sc.nextInt();
        guardar_bicicleta(id_bicicleta, anio_construccion, bici_id_producto);
    }

    public static void guardar_intencion(int id_intencion, String fecha_hora, String inte_alias_cliente, int inte_id_producto) {
        String proveedor_sql = "INSERT INTO Intencion VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(proveedor_sql);
            comando.setInt(1, id_intencion);
            comando.setString(2, fecha_hora);
            comando.setString(3, inte_alias_cliente);
            comando.setInt(4, inte_id_producto);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            ex.printStackTrace();
        }
    }

    public static void nueva_intencion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id de la intencion: ");
        int id_intencion = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese fecha y hora: ");
        String fecha_hora = sc.nextLine();
        System.out.println("Ingrese alias de cliente: ");
        String inte_alias_cliente = sc.nextLine();
        System.out.println("Ingrese inte_id_producto: ");
        int bici_id_producto = sc.nextInt();
        guardar_intencion(id_intencion, fecha_hora, inte_alias_cliente, bici_id_producto);
    }

    public static void guardar_motocicleta(int id_moto, int autonomia, int moto_id_proveedor, int moto_id_producto) {
        String proveedor_sql = "INSERT INTO Motocicleta VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = conn.prepareStatement(proveedor_sql);
            comando.setInt(1, id_moto);
            comando.setInt(2, autonomia);
            comando.setInt(3, moto_id_proveedor);
            comando.setInt(4, moto_id_producto);
            int registros_afectados = comando.executeUpdate();
            System.out.println("Registros afectados -> " + registros_afectados);
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            ex.printStackTrace();
        }
    }

    public static void nueva_motocicleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id de la Motocicleta: ");
        int id_moto = sc.nextInt();
        System.out.println("Ingrese autonomia de batería: ");
        int autonomia = sc.nextInt();
        System.out.println("Ingrese moto_id_proveedor: ");
        int moto_id_proveedor = sc.nextInt();
        System.out.println("Ingrese moto_id_producto: ");
        int moto_id_producto = sc.nextInt();
        guardar_motocicleta(id_moto, autonomia, moto_id_proveedor, moto_id_producto);


    }


//====================== LISTAR ================================================

    public static void listar_productos() {
        String sql = "SELECT * FROM Producto";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                String id_producto = resultados.getString(1);
                String nombre_fabricante = resultados.getString(2);
                int precio = resultados.getInt(3);
                System.out.println(">>>>>>>>   Producto   <<<<<<<<");
                System.out.println("Id:         " + id_producto);
                System.out.println("Fabricante: " + nombre_fabricante);
                System.out.println("Precio:     " + precio);
                System.out.println("-------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_productos_por_id() {
        String sql = "SELECT * FROM Producto";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            System.out.println(">>>>>>>>   Producto   <<<<<<<<");
            while (resultados.next()) {
                String id_producto = resultados.getString(1);
                System.out.println("Id:  " + id_producto);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_Cliente() {
        String sql = "SELECT * FROM Cliente";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                String alias_cliente = resultados.getString(1);
                String nombre_cliente = resultados.getString(2);
                String apellidos_cliente = resultados.getString(3);
                String email_cliente = resultados.getString(4);
                String celular_cliente = resultados.getString(5);
                int contrasenia_cliente = resultados.getInt(6);
                Date fecha_de_nacimiento_cliente = resultados.getDate(7);
                System.out.println(">>>>>>>>   Cliente   <<<<<<<<");
                System.out.println("Username   : " + alias_cliente);
                System.out.println("Nombre     : " + nombre_cliente);
                System.out.println("Apellido   : " + apellidos_cliente);
                System.out.println("Email      : " + email_cliente);
                System.out.println("Num Celular: " + celular_cliente);
                System.out.println("Constraseña: " + contrasenia_cliente);
                System.out.println("Fecha nacim: " + fecha_de_nacimiento_cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_proveedor() {
        String sql = "SELECT * FROM Proveedor";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                int prov_id = resultados.getInt(1);
                String prov_nombre = resultados.getString(2);
                String prov_direccion = resultados.getString(3);
                String prov_telefono = resultados.getString(4);
                System.out.println(">>>>>>>>   Proveedor   <<<<<<<<");
                System.out.println("Id    :    " + prov_id);
                System.out.println("Nombre:    " + prov_nombre);
                System.out.println("Direccion: " + prov_direccion);
                System.out.println("Teléfono:  " + prov_telefono);
                System.out.println("-------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_intencion() {
        String sql = "SELECT * FROM Intencion";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                int id_intencion = resultados.getInt(1);
                String fecha_hora = resultados.getString(2);
                String inte_alias_cliente = resultados.getString(3);
                int inte_id_producto = resultados.getInt(4);
                System.out.println(">>>>>>>>   Intención   <<<<<<<<");
                System.out.println("Id          : " + id_intencion);
                System.out.println("Fecha y Hora: " + fecha_hora);
                System.out.println("Alias       : " + inte_alias_cliente);
                System.out.println("id producto : " + inte_id_producto);
                System.out.println("-------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_bicicleta() {
        String sql = "SELECT * FROM Bicicleta";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                int id_bicicleta = resultados.getInt(1);
                int anio_construccion = resultados.getInt(2);
                int bici_id_producto = resultados.getInt(3);
                System.out.println(">>>>>>>>   Bicicletas   <<<<<<<<");
                System.out.println("Id          : " + id_bicicleta);
                System.out.println("Fecha y Hora: " + anio_construccion);
                System.out.println("Alias       : " + bici_id_producto);
                System.out.println("-------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void listar_motocicleta() {
        String sql = "SELECT * FROM Motocicleta";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultados = comando.executeQuery();
            while (resultados.next()) {
                int id_moto = resultados.getInt(1);
                int autonomia = resultados.getInt(2);
                int moto_id_proveedor = resultados.getInt(3);
                int moto_id_producto = resultados.getInt(4);
                System.out.println(">>>>>>>>   Motocicletas   <<<<<<<<");
                System.out.println("Id          : " + id_moto);
                System.out.println("Autonomia   : " + autonomia + " horas");
                System.out.println("ID proveedor: " + moto_id_proveedor);
                System.out.println("ID producto : " + moto_id_producto);
                System.out.println("-------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //===================== *ACTUALIZAR PRODUCTO ====================================
    public static void obtenerProducto(int id_producto) {
        String sql = "SELECT * FROM Producto WHERE id_producto=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_producto);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            String nombre_fabricante = resultado.getString(2);
            int precio = resultado.getInt(3);
            System.out.println(">>>>>>>>   Producto   <<<<<<<<");
            System.out.println("Id:         " + id_producto);
            System.out.println("Fabricante: " + nombre_fabricante);
            System.out.println("Precio:     " + precio);

        } catch (SQLException ex) {
            System.out.println("Error al obtener Producto");
            ex.printStackTrace();
        }
    }

    public static void actualizar_producto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite ID el producto a modificar: ");
        int id_producto = Integer.parseInt(sc.nextLine());
        obtenerProducto(id_producto);
        System.out.println("Nuevos campos: ");
        System.out.println("Fabricante: ");
        String nombre_fabricante = sc.nextLine();
        System.out.println("Precio: ");
        int precio = Integer.parseInt(sc.nextLine());
        guardar_producto_actualizado(id_producto, nombre_fabricante, precio);
    }

    public static void guardar_producto_actualizado(int id_producto, String nombre_fabricante, int precio) {
        String sql = "UPDATE Producto SET nombre_fabricante =?, precio =? WHERE id_producto=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nombre_fabricante);
            comando.setInt(2, precio);
            comando.setInt(3, id_producto);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Registros modificados: " + registros_modificados);

        } catch (SQLException ex) {
            System.out.println("Error al actualizar");
            ex.printStackTrace();
        }
    }

    //                      *ACTUALIZAR CLIENTE
    public static void obtener_cliente(String alias_cliente) {
        String sql = "SELECT * FROM Cliente WHERE alias_cliente=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, alias_cliente);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            String nombre_cliente = resultado.getString(2);
            String apellidos_cliente = resultado.getString(3);
            String email_cliente = resultado.getString(4);
            String celular_cliente = resultado.getString(5);
            String contrasenia_cliente = resultado.getString(6);
            String fecha_de_nacimiento_cliente = resultado.getString(7);


            System.out.println(">>>>>>>>   Cliente   <<<<<<<<");
            System.out.println("Username        : " + alias_cliente);
            System.out.println("Nombre          : " + nombre_cliente);
            System.out.println("Apellidos       : " + apellidos_cliente);
            System.out.println("Email           : " + email_cliente);
            System.out.println("Celular         : " + celular_cliente);
            System.out.println("Contraseña      : " + contrasenia_cliente);
            System.out.println("Fecha nacimiento: " + fecha_de_nacimiento_cliente);


        } catch (SQLException ex) {
            System.out.println("Error al obtener Cliente");
            ex.printStackTrace();
        }

    }

    public static void actualizar_cliente() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el cliente a modificar: ");
        String alias_cliente = sc.nextLine();
        obtener_cliente(alias_cliente);
        System.out.println(">>>>>> Nuevos campos <<<<<< ");
        System.out.println("Nombre             : ");
        String nombre_cliente = sc.nextLine();
        System.out.println("Apellidos          : ");
        String apellidos_cliente = sc.nextLine();
        System.out.println("Email              : ");
        String email_cliente = sc.nextLine();
        System.out.println("Celular            : ");
        String celular_cliente = sc.nextLine();
        System.out.println("Contraseña         : ");
        int contrasenia_cliente = Integer.parseInt(sc.nextLine());
        System.out.println("Fecha de nacimiento: ");
        String fecha_de_nacimiento_string = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fecha_de_nacimiento_cliente = sdf.parse(fecha_de_nacimiento_string);
        guardar_cliente_actualizado(alias_cliente, nombre_cliente, apellidos_cliente, email_cliente, celular_cliente, contrasenia_cliente, new Date(fecha_de_nacimiento_cliente.getTime()));

    }

    public static void guardar_cliente_actualizado(String alias_cliente, String nombre, String apellidos, String email, String celular, int contrasenia, Date fecha_de_nacimiento_cliente) {
        String sql = "UPDATE Cliente SET nombre =?, apellidos =?,email=?,celular=?,contrasenia=?,fecha_de_nacimiento_cliente=? WHERE alias_cliente=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, nombre);
            comando.setString(2, apellidos);
            comando.setString(3, email);
            comando.setString(4, celular);
            comando.setInt(5, contrasenia);
            comando.setDate(6, fecha_de_nacimiento_cliente);
            comando.setString(7, alias_cliente);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Registros modificados: " + registros_modificados);

        } catch (SQLException ex) {
            System.out.println("Error al actualizar cliente");
            ex.printStackTrace();
        }


    }


    //                      ACTUALIZAR PROVEEDOR
    public static void obtenerProveedor(int prov_id) {
        String sql = "SELECT * FROM Proveedor WHERE prov_id=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, prov_id);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            String prov_nombre = resultado.getString(2);
            String prov_direccion = resultado.getString(3);
            String prov_telefono = resultado.getString(4);

            System.out.println(">>>>>>>>   Proveedor   <<<<<<<<");
            System.out.println("Nombre    : " + prov_nombre);
            System.out.println("Direccion : " + prov_direccion);
            System.out.println("Telefono  : " + prov_telefono);

        } catch (SQLException ex) {
            System.out.println("Error al obtener Proveedor");
            ex.printStackTrace();
        }

    }

    public static void actualizar_proveedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite ID del Proveedor a modificar: ");
        int prov_id = Integer.parseInt(sc.nextLine());
        obtenerProveedor(prov_id);
        System.out.println("Nuevos campos: ");
        System.out.println("Nombre: ");
        String prov_nombre = sc.nextLine();
        System.out.println("Direccion: ");
        String prov_direccion = sc.nextLine();
        System.out.println("Teléfono: ");
        String prov_telefono = sc.nextLine();
        guardar_producto_actualizado(prov_id, prov_nombre, prov_direccion, prov_telefono);
    }

    public static void guardar_producto_actualizado(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        String sql = "UPDATE Proveedor SET prov_nombre =?, prov_direccion =?,prov_telefono=? WHERE prov_id=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, prov_nombre);
            comando.setString(2, prov_direccion);
            comando.setString(3, prov_telefono);
            comando.setInt(4, prov_id);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Registros modificados: " + registros_modificados);

        } catch (SQLException ex) {
            System.out.println("Error al guardar proveedor actualizado");
            ex.printStackTrace();
        }
    }

    //                     ACTUALIZAR INTENCION
    public static void obtener_intencion(int id_intencion) {
        String sql = "SELECT * FROM Intencion WHERE id_intencion=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_intencion);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            String fecha_hora = resultado.getString(2);
            String inte_alias_cliente = resultado.getString(3);
            int inte_id_producto = resultado.getInt(4);
            System.out.println("       >>>> INTENCION  <<<<<<");
            System.out.println("Fecha y Hora     :" + fecha_hora);
            System.out.println("Alias del cliente: " + inte_alias_cliente);
            System.out.println("Id del PRODUCTO  : " + inte_id_producto);
        } catch (SQLException ex) {
            System.out.println("Erro al obtener la intencion de compra");
            ex.printStackTrace();
        }

    }

    public static void actualizar_intencion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la intencion a modificar");
        int id_intencion = Integer.parseInt(sc.nextLine());
        obtener_intencion(id_intencion);
        System.out.println("   Modificando Intencion   ");
        System.out.println("Fecha y hora      : ");
        String fecha_hora = sc.nextLine();
        System.out.println("Alias del cliente :");
        String inte_alias_cliente = sc.nextLine();
        System.out.println("ID de Producto    : ");
        int inte_id_producto = Integer.parseInt(sc.nextLine());
        guardar_intencion_actualizada(id_intencion, fecha_hora, inte_alias_cliente, inte_id_producto);
    }

    public static void guardar_intencion_actualizada(int id_intencion, String fecha_hora, String inte_alias_cliente, int inte_id_producto) {
        String sql = "UPDATE Intencion SET fecha_hora =?,inte_alias_cliente =?, inte_id_producto =? WHERE id_intencion=? ";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, fecha_hora);
            comando.setString(2, inte_alias_cliente);
            comando.setInt(3, inte_id_producto);
            comando.setInt(4, id_intencion);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Numero de registros modificados ->" + registros_modificados);
        } catch (SQLException ex) {
            System.out.println("Error al guardar la actualizacion de la intencion. Comuniquese con el programador");
            ex.printStackTrace();
        }
    }


    //                     ACTUALIZAR BICICLETA
    public static void obtener_bicicleta(int id_bicicleta) {
        String sql = "SELECT * FROM Bicicleta WHERE id_bicicleta =?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_bicicleta);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            int anio_construccion = resultado.getInt(2);
            int bici_id_producto = resultado.getInt(3);
            System.out.println("    Bicicleta   ");
            System.out.println("Año de construccion : " + anio_construccion);
            System.out.println("ID producto         : " + bici_id_producto);
        } catch (SQLException ex) {
            System.out.println("Error al obtener Bicicleta");
            ex.printStackTrace();
        }
    }

    public static void actualizar_bicicleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite id de Bicicleta a modificar");
        int id_bicicleta = Integer.parseInt(sc.nextLine());
        obtener_bicicleta(id_bicicleta);
        System.out.println("       Campos a modificar   ");
        System.out.println("Año de construccion : ");
        int anio_construccion = Integer.parseInt(sc.nextLine());
        System.out.println("ID producto         :");
        int bici_id_producto = Integer.parseInt(sc.nextLine());
        guardar_bicicleta_actualizada(id_bicicleta, anio_construccion, bici_id_producto);
    }

    public static void guardar_bicicleta_actualizada(int id_bicicleta, int anio_construccion, int bici_id_producto) {
        String sql = "UPDATE Bicicleta SET anio_construccion =?, bici_id_producto =? WHERE id_bicicleta =?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, anio_construccion);
            comando.setInt(2, bici_id_producto);
            comando.setInt(3, id_bicicleta);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Registros modificados -> " + registros_modificados);
        } catch (SQLException ex) {
            System.out.println("Error al guardar actualizacion de la bicicleta");
            ex.printStackTrace();
        }
    }

//                     ACTUALIZAR MOTOCICLETA

    public static void obtener_motocicleta(int id_moto) {
        String sql = "SELECT * FROM Motocicleta WHERE id_moto=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_moto);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            int autonomia = resultado.getInt(2);
            int moto_id_proveedor = resultado.getInt(3);
            int moto_id_producto = resultado.getInt(4);
            System.out.println("     Motocicleta   ");
            System.out.println("Autonomia    : " + autonomia);
            System.out.println("ID proveedor : " + moto_id_proveedor);
            System.out.println("ID producto  : " + moto_id_producto);
        } catch (SQLException ex) {
            System.out.println("Error al obtener Motocicleta");
            ex.printStackTrace();
        }
    }

    public static void actualizar_motocicleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el ID de la motocicleta a modificar");
        int id_moto = Integer.parseInt(sc.nextLine());
        obtener_motocicleta(id_moto);
        System.out.println(" >>>  Nuevos campos <<<");
        System.out.println("Autonomia     :");
        int autonomia = Integer.parseInt(sc.nextLine());
        System.out.println("ID proveedor  :");
        int moto_id_proveedor = Integer.parseInt(sc.nextLine());
        System.out.println("ID producto   :");
        int moto_id_producto = Integer.parseInt(sc.nextLine());
        guardar_motocicleta_actualizada(id_moto, autonomia, moto_id_proveedor, moto_id_producto);
    }

    public static void guardar_motocicleta_actualizada(int id_moto, int autonomia, int moto_id_proveedor, int moto_id_producto) {
        String sql = "UPDATE Motocicleta SET autonomia = ?, moto_id_proveedor = ?, moto_id_producto = ? WHERE id_moto = ?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, autonomia);
            comando.setInt(2, moto_id_proveedor);
            comando.setInt(3, moto_id_producto);
            comando.setInt(4, id_moto);
            int registros_modificados = comando.executeUpdate();
            System.out.println("Registros modificados : " + registros_modificados);
        } catch (SQLException ex) {
            System.out.println("Error al guardar la actualizacion de la moto");
            ex.printStackTrace();
        }
    }


    //================     BORRAR PRODUCTO      =======================
    public static void borrar_intencion(int id_producto) {
        String sql = "DELETE FROM Intencion WHERE inte_id_producto=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_producto);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Cantidad de intenciones borradas ->" + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al eliminar intencion");
            ex.printStackTrace();
        }
    }

    public static void borrar_bici_o_moto(int id_producto) {

        if (id_producto <= 5) {
            String sql = "DELETE FROM Bicicleta WHERE bici_id_producto=?";
            try {
                PreparedStatement comando = conn.prepareStatement(sql);
                comando.setInt(1, id_producto);
                int registros_borrados = comando.executeUpdate();
                System.out.println("Cantidad de Bicicletas borradas ->" + registros_borrados);
            } catch (SQLException ex) {
                System.out.println("Error al borrar bicicleta");
                ex.printStackTrace();
            }
        } else if (id_producto > 5) {
            String sql = "DELETE FROM Motocicleta WHERE moto_id_producto=?";
            try {
                PreparedStatement comando = conn.prepareStatement(sql);
                comando.setInt(1, id_producto);
                int registros_borrados = comando.executeUpdate();
                System.out.println("Cantidad de Motos borradas ->" + registros_borrados);
            } catch (SQLException ex) {
                System.out.println("Error al borrar la Motocicleta");
                ex.printStackTrace();
            }
        }


    }

    public static void borrar_producto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el producto a borrar: ");
        int id_producto = Integer.parseInt(sc.nextLine());
        borrar_intencion(id_producto);
        borrar_bici_o_moto(id_producto);
        String sql = "DELETE FROM Producto WHERE id_producto =?";

        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_producto);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Cantidad de productos borrados ->" + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al eliminar producto");
            ex.printStackTrace();

        }

    }


    //                     BORRAR CLIENTES
    public static void eliminar_intencion_cliente(String alias_cliente) {
        String sql = "DELETE FROM Intencion WHERE inte_alias_cliente=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, alias_cliente);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Intenciones de cliente borrados -> " + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar intencion de cliente");
            ex.printStackTrace();
        }
    }

    public static void borrar_cliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el alias del cliente a eliminar");
        String alias_cliente = sc.nextLine();
        eliminar_intencion_cliente(alias_cliente);
        String sql = "DELETE FROM Cliente WHERE alias_cliente =?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, alias_cliente);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Clientes borrados -> " + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar intencion de cliente");
            ex.printStackTrace();
        }

    }

    //                     BORRAR PROVEEDOR
    public static void borrar_moto_proveedor(int prov_id) {
        String sql = "DELETE FROM Motocicleta WHERE moto_id_proveedor=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, prov_id);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Motos de proveedor borradas->" + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar moto de proveedor");
            ex.printStackTrace();
        }
    }

    public static void borrar_proveedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el ID del proveedor a eliminar");
        int prov_id = Integer.parseInt(sc.nextLine());
        borrar_moto_proveedor(prov_id);
        String sql = "DELETE FROM Proveedor WHERE prov_id =?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, prov_id);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Proveedores borrados: " + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar Proveedor");
            ex.printStackTrace();
        }
    }
//                     BORRAR BICICLETA

    public static void borrar_bicicleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el ID de la bicicleta a borrar ");
        int id_bicicleta = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM Bicicleta WHERE id_bicicleta=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_bicicleta);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Bicicletas borrados->" + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar Bicicleta");
            ex.printStackTrace();
        }
    }


//                     BORRAR MOTOCICLETA

    public static void borrar_motocicleta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el ID de la Motocicleta a borrar ");
        int id_moto = Integer.parseInt(sc.nextLine());
        //borrar_prod_motocicicleta(id_moto);
        //borrar_intencion_moto(id_moto);
        String sql = "DELETE FROM Motocicleta WHERE id_moto=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_moto);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Motocicletas borrados->" + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar Motocicleta");
            ex.printStackTrace();
        }
    }

//                       BORRAR INTENCION

    public static void borrar_intencion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione la intencion a eliminar");
        int id_intencion = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM Intencion WHERE id_intencion=?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id_intencion);
            int registros_borrados = comando.executeUpdate();
            System.out.println("Intenciones borradas -> " + registros_borrados);
        } catch (SQLException ex) {
            System.out.println("Error al borrar intencion");
            ex.printStackTrace();
        }


    }
}


