package org.acme.getting.started.resource;

import org.acme.getting.started.model.Car;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> list() {
        return Car.listAll();
    }

    @POST
    @Transactional
    public Car create(Car car){
        car.persist();
        return car;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id")Long id){
        Car.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Car update(@PathParam("id")Long id,Car car){
        Car carDB = Car.findById(id);
        carDB.name = car.name;
        return carDB;
    }
}