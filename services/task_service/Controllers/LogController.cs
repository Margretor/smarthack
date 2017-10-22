using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Tasks.Context;
using Tasks.Models;
using Tasks.Repository;

namespace Tasks.Controllers
{
    public class LogController : ApiController
    {
        [HttpPost]
        public IHttpActionResult Add(Log log)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Logs.Add(log);
                ctx.SaveChanges();
            }
            return Ok(log);
        }

        [HttpPost]
        public IHttpActionResult Remove(Log log)
        {
            LogOperations.Delete(log);
            return Ok();
        }

        [HttpPost]
        public IHttpActionResult Update(Log log)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Entry(log).State = System.Data.Entity.EntityState.Modified;
                ctx.SaveChanges();
            }
            return Ok(log);
        }
    }
}
