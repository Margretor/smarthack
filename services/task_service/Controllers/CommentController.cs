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
    public class CommentController : ApiController
    {
        [HttpPost]
        public IHttpActionResult Add(Comment Comment)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Comments.Add(Comment);
                ctx.SaveChanges();
            }
            return Ok(Comment);
        }

        [HttpPost]
        public IHttpActionResult Remove(Comment Comment)
        {
            CommentOperations.Delete(Comment);
            return Ok();
        }

        [HttpPost]
        public IHttpActionResult Update(Comment Comment)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Entry(Comment).State = System.Data.Entity.EntityState.Modified;
                ctx.SaveChanges();
            }
            return Ok(Comment);
        }

        [HttpGet]
        public IHttpActionResult Mock()
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Comments.Add(new Comment
                {
                    Task = 1,
                    TimeStamp = DateTime.Now,
                    User = "80806659-3e67-4082-9d23-efad4f88dd5b",
                    Message = "yolo"
                });

                ctx.Comments.Add(new Comment
                {
                    Task = 2,
                    TimeStamp = DateTime.Now,
                    User = "cfffa81e-d03b-4738-9d36-234aefbea12e",
                    Message = "hello"
                });

                ctx.SaveChanges();
            }

            return Ok();
        }
    }
}
