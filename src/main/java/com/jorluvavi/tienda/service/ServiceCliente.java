
package com.jorluvavi.tienda.service;

import com.jorluvavi.tienda.dao.IClienteDao;
import com.jorluvavi.tienda.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class ServiceCliente implements IServiceCliente {
    
    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente encontrarCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getId()).orElse(null);
    }
    
}