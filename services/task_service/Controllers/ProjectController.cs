using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Tasks.Context;
using Tasks.Models;

namespace Tasks.Controllers
{
    public class ProjectController : ApiController
    {
        [HttpPost]
        public IHttpActionResult Add(Project Project)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Projects.Add(Project);
                ctx.SaveChanges();
            }
            return Ok(Project);
        }

        [HttpPost]
        public IHttpActionResult Update(Project Project)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Entry(Project).State = System.Data.Entity.EntityState.Modified;
                ctx.SaveChanges();
            }
            return Ok(Project);
        }

        [HttpGet]
        public IHttpActionResult Mock()
        {
            Project p = new Project
            {
                Name = "management platform",
                Owner = "cfffa81e-d03b-4738-9d36-234aefbea12e"
            };

            Project p1 = new Project
            {
                Name = "testing platform",
                Owner = "80806659-3e67-4082-9d23-efad4f88dd5b"
            };

            using (var ctx = new DatabaseContext())
            {
                ctx.Projects.Add(p);
                ctx.Projects.Add(p1);
                ctx.SaveChanges();
            }

            return Ok();
        }
    }
}