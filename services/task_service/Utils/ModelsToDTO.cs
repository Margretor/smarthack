using System;
using System.Collections.Generic;
using System.Linq;
using Tasks.APICaller;
using Tasks.Context;
using Tasks.DTO;
using Tasks.Models;

namespace Tasks.Utils
{
    public class ModelsToDTO
    {
        private ModelsToDTO() { }

        public static CommentDTO CommentToDTO(Comment comment)
        {
            User user = UserApi.GetUser(comment.User);

            return new CommentDTO
            {
                Date = comment.TimeStamp,
                Username = user.Username,
                Message = comment.Message
            };
        }

        public static LogDTO LogToDTO(Log log)
        {
            User user = UserApi.GetUser(log.User);

            return new LogDTO
            {
                Date = log.Date,
                User = user.Username,
                Time = log.Time
            };
        }

        public static ProjectDTO ProjectToDTO(Project project)
        {
            User user = UserApi.GetUser(project.Owner);

            return new ProjectDTO
            {
                Owner = user.Username,
                Name = project.Name
            };
        }

        public static TaskDTO TaskToDTO(Task task)
        {
            User reporter = UserApi.GetUser(task.Reporter);
            User owner = UserApi.GetUser(task.Owner);

            TaskDTO result = new TaskDTO
            {
                Id = task.Id,
                Start = task.Start,
                Deadline = task.Deadline,
                Status = task.Status.ToString(),
                Type = task.Type.ToString(),
                Priority = task.Priority.ToString(),
                Title = task.Title,
                Reporter = reporter.Username,
                Owner = owner.Username,
                Description = task.Description,
                Estimation = task.Estimation
            };

            result.Comments = new List<CommentDTO>();
            result.Logs = new List<LogDTO>();

            TimeSpan logged = new TimeSpan(0);

            using (var ctx = new DatabaseContext())
            {
                var logsList = ctx.Logs.Where(x => x.Task == task.Id);
                foreach (Log l in logsList)
                {
                    logged += l.Time;
                    result.Logs.Add(LogToDTO(l));
                }

                result.Logged = logged;

                var commentsList = ctx.Comments.Where(x => x.Task == task.Id);
                foreach (Comment c in commentsList)
                    result.Comments.Add(CommentToDTO(c));

                result.Project = ProjectToDTO(ctx.Projects.FirstOrDefault(x => x.Id == task.Project));
            }

            return result;
        }
    }
}