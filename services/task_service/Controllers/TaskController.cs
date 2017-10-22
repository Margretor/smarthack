using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Tasks.Context;
using Tasks.DTO;
using Tasks.Models;
using Tasks.Utils;

namespace Tasks.Controllers
{
    public class TaskController : ApiController
    {
        [HttpGet]
        public IHttpActionResult GetTask(int id)
        {
            using (var ctx = new DatabaseContext())
            {
                return Ok(ModelsToDTO.TaskToDTO(ctx.Tasks.FirstOrDefault(x => x.Id == id)));
            }
        }

        [HttpGet]
        public IHttpActionResult GetList(int project)
        {
            IList<TaskDTO> result = new List<TaskDTO>();

            IQueryable<Task> list;
            using (var ctx = new DatabaseContext())
            {
                list = ctx.Tasks.Where(x => x.Project == project);

                foreach (Task t in list)
                    result.Add(ModelsToDTO.TaskToDTO(t));
            }

            return Ok(result);
        }

        [HttpPost]
        public IHttpActionResult Add(Task task)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Tasks.Add(task);
                ctx.SaveChanges();
            }
            return Ok(task);
        }

        [HttpPost]
        public IHttpActionResult Update(Task task)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Entry(task).State = System.Data.Entity.EntityState.Modified;
                ctx.SaveChanges();
            }
            return Ok(task);
        }

        [HttpGet]
        public IHttpActionResult Mock()
        {
#region xxx
            Task t1 = new Task
            {
                Start = DateTime.Now,
                Deadline = DateTime.Now + TimeSpan.FromDays(4),
                Status = Status.Open,
                Type = Models.Type.Task,
                Priority = Priority.Medium,
                Project = 1,
                Title = "first random task",
                Reporter = "cfffa81e-d03b-4738-9d36-234aefbea12e",
                Owner = "cfffa81e-d03b-4738-9d36-234aefbea12e",
                Description = "get work done motherfucker",
                Estimation = TimeSpan.FromHours(4)
            };
            Task t2 = new Task
            {
                Start = DateTime.Now,
                Deadline = DateTime.Now + TimeSpan.FromDays(3),
                Status = Status.InProgress,
                Type = Models.Type.Bug,
                Priority = Priority.Hight,
                Project = 1,
                Title = "second random task",
                Reporter = "cfffa81e-d03b-4738-9d36-234aefbea12e",
                Owner = "cfffa81e-d03b-4738-9d36-234aefbea12e",
                Description = "please get work done",
                Estimation = TimeSpan.FromHours(8)
            };
            Task t3 = new Task
            {
                Start = DateTime.Now,
                Deadline = DateTime.Now + TimeSpan.FromDays(5),
                Status = Status.ReadyForTesting,
                Type = Models.Type.Bug,
                Priority = Priority.Low,
                Project = 2,
                Title = "third random task",
                Reporter = "80806659-3e67-4082-9d23-efad4f88dd5b",
                Owner = "80806659-3e67-4082-9d23-efad4f88dd5b",
                Description = "what is that ??",
                Estimation = TimeSpan.FromHours(6)
            };
            Task t4 = new Task
            {
                Start = DateTime.Now,
                Deadline = DateTime.Now + TimeSpan.FromDays(1),
                Status = Status.ReadyForTesting,
                Type = Models.Type.Task,
                Priority = Priority.Low,
                Project = 2,
                Title = "4th random task",
                Reporter = "80806659-3e67-4082-9d23-efad4f88dd5b",
                Owner = "80806659-3e67-4082-9d23-efad4f88dd5b",
                Description = "very strange",
                Estimation = TimeSpan.FromHours(12)
            };
            #endregion



            using (var ctx = new DatabaseContext())
            {
                ctx.Tasks.Add(t1);
                ctx.Tasks.Add(t2);
                ctx.Tasks.Add(t3);
                ctx.Tasks.Add(t4);
                ctx.SaveChanges();
            }

            return Ok();
        }

    }
}
